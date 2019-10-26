package com.fiap.avaliacoes.api.controller;

import com.fiap.avaliacoes.api.model.Avaliacao;
import com.fiap.avaliacoes.api.reository.MyAvaliacaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/avaliacoes")
@Api(tags = "Avaliacoes", description = "Cadastrar e Listar todas as PlayList.")
public class AvaliacaoController {

	@Autowired
	private MyAvaliacaoRepository myAvaliacaoRepository;
	private Logger logger = Logger.getLogger(Avaliacao.class.getName());

	@ApiOperation(
			value="Criar uma PlayList de filmes e series.",
			response= Avaliacao.class,
			notes="Essa operação criará uma PlayList para um determinando filme ou serie.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200,
					message="Retorna os Dados da PlayList com uma mensagem de sucesso",
					response= Avaliacao.class
			),
			@ApiResponse(
					code=500,
					message="Caso tenhamos algum erro vamos retornar um Erro com a Exception",
					response= Avaliacao.class
			)
	})
	@PostMapping("/criarAvaliacao")
	public ResponseEntity<Avaliacao> criarAvaliacao(@Valid @RequestBody Avaliacao avaliacao){
		ResponseEntity<Avaliacao> response = null;
		try {
			response = new ResponseEntity<Avaliacao>(myAvaliacaoRepository.save(avaliacao), HttpStatus.OK);
		} catch (Exception e) {
			logger.log(Level.SEVERE,  "Erro criar Avaliacao", e);
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("/buscarAvaliacao")
	public ResponseEntity<List<Avaliacao>> buscarAvaliacao() {

		ResponseEntity<List<Avaliacao>> response = null;

		try {
			response = new ResponseEntity<List<Avaliacao>>(myAvaliacaoRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro pegando lista de Avaliacoes", e);
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

}