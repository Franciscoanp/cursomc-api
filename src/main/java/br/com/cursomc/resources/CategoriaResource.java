package br.com.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/categorias")
@Api(value="API REST Categorias")
@CrossOrigin(origins="*")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value="Busca uma categoria", notes="Essa operação retorna uma categoria.")
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria categoria = categoriaService.buscar(id);
	
		return ResponseEntity.ok(categoria);
	}
}
