package controller;

import com.curso.api_curso.domains.Aluno;
import com.curso.api_curso.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoControllerTest {

    AlunoService alunoService;

    @BeforeEach
    public void setUp(){
        this.alunoService = Mockito.mock(AlunoService.class);
    }

    @Test
    void salvaAlunoComSucesso(){

        //Entrada
        Aluno esperado = new Aluno("Fulano","123456","08/08/1988","51-123456789");
        Mockito.when(alunoRepository.save(esperado)).thenReturn(esperado);

        //Execucao
        AlunoService alunoService = new AlunoService(alunoRepository);
        Aluno atual = alunoService.salvar(esperado);

        //verficacao
        assertEquals(esperado, atual);
        //   Mockito.verify(alunoRepository, Mockito.times(1)).save(esperado);

    }

}
