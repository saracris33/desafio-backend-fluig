package br.com.veiculo.infrastructure.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.veiculo.application.command.IncluirFotoCarroCommand;
import br.com.veiculo.application.representation.FotoVeiculoRepresentation;
import br.com.veiculo.application.service.VeiculoService;
import br.com.veiculo.domain.entity.Veiculo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Veiculos")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1" + "/veiculos/{id-veiculo}/foto")
public class VeiculoFotoController {
	
	private final VeiculoService service;
	
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoVeiculoRepresentation uploadFoto(@PathVariable("id-veiculo") Long idVeiculo,
			@Valid IncluirFotoCarroCommand command) {
		log.info("Upload foto veiculo");
		Veiculo veiculo = service.buscaOuFalha(idVeiculo);
		
		MultipartFile arquivo = command.getArquivo();
		
	    FotoVeiculoRepresentation representation = new FotoVeiculoRepresentation();
	    byte[] imagem= null;
	    String imagemBase64 ="";
		try {
			imagem = arquivo.getBytes();
	        String imagemSerializado = Base64.getEncoder().encodeToString(imagem);
	        imagemBase64 = new String("data:" + arquivo.getContentType() + ";base64," + imagemSerializado);
	    
	        veiculo.setImagem(imagemSerializado);
	        service.salva(veiculo);
	    
	        representation.setIdVeiculo(veiculo.getId());
	        representation.setContentType(arquivo.getContentType());
	        representation.setImagemBase64(imagemBase64);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return representation;
	}
	
	@GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> downloadFoto(@PathVariable("id-veiculo") Long idVeiculo) {
		log.info("Download foto veiculo");
		Veiculo veiculo = service.buscaOuFalha(idVeiculo);

        //download imagem base64 banco
        byte[] arrayBytesDecode = Base64.getDecoder().decode(veiculo.getImagem());
    
        try {
			Files.write(Paths.get("C:\\catalogo\\image.jpeg"), arrayBytesDecode);
		} catch (IOException e) {
			e.printStackTrace();
		}
   
    	var headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=foto-carro.jpeg");
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.headers(headers)
				.body(arrayBytesDecode);
	}

}
