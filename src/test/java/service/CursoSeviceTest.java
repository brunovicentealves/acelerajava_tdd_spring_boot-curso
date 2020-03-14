package service;

import com.curso.api_curso.domains.Aluno;
import com.curso.api_curso.domains.Curso;
import com.curso.api_curso.repository.AlunoRepository;
import com.curso.api_curso.repository.CursoRepository;
import com.curso.api_curso.service.AlunoService;
import com.curso.api_curso.service.CursoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoSeviceTest {


    private CursoRepository cursoRepository;

    @BeforeEach
    public void setUp(){
        this.cursoRepository = Mockito.mock(CursoRepository.class);
    }


    @Test
    void salvaCursoComSucesso(){

        //Entrada

        Curso esperado = new Curso("excel","microsoft","informatica basica","tecnico");
        Mockito.when(cursoRepository.save(esperado)).thenReturn(esperado);

        //Execucao
        CursoService cursoService = new CursoService(cursoRepository);

        Curso atual = cursoService.salvar(esperado);

        //verficacao
        assertEquals(esperado, atual);
        //   Mockito.verify(alunoRepository, Mockito.times(1)).save(esperado);

    }


    @Test
    void falhaAoSalvarSemNomeCurso(){
        //entrada
        Curso esperado = new Curso(null,"microsoft","informatica basica","tecnico");

       CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);

    }


    @Test
    void falhaAoSalvarSemDescricao(){
        //entrada
        Curso esperado = new Curso("excel",null,"informatica basica","tecnico");

        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);

    }

    @Test
    void falhaAoSalvarSemRequisito(){
        //entrada
        Curso esperado = new Curso("excel","microsoft",null,"tecnico");

        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);

    }


    @Test
    void falhaAoSalvarSemModalidade(){
        //entrada
        Curso esperado = new Curso(null,"microsoft","informatica basica",null);

        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);

    }

}
