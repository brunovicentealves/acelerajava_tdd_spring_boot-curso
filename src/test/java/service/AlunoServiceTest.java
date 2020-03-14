package service;

import com.curso.api_curso.domains.Aluno;
import com.curso.api_curso.repository.AlunoRepository;
import com.curso.api_curso.service.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlunoServiceTest {

    private AlunoRepository alunoRepository;


    @BeforeEach
    public void setUp(){
        this.alunoRepository = Mockito.mock(AlunoRepository.class);
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

    @Test
    void falhaAoSalvarSemNome(){
      //entrada
        Aluno esperado = new Aluno(null,"123456","08/08/1988","51-123456789");

        AlunoService alunoService = new AlunoService(alunoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);

    }

    @Test
    void falhaSalvarSemCpf(){
        //entradas
        Aluno esperado = new Aluno("pedro",null,"08/08/1988","51-123456789");
        AlunoService alunoService = new AlunoService(alunoRepository);
        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);

    }

    @Test
    void falhaSalvarSemDataNAscimento(){

        Aluno esperado = new Aluno("pedro","54345345435",null,"51-123456789");
        AlunoService alunoService = new AlunoService(alunoRepository);
        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);


    }

    @Test
    void falhaSalvarSemTelefone(){
        Aluno esperado = new Aluno("pedro","54345345435","16/11/1996",null);
        AlunoService alunoService = new AlunoService(alunoRepository);
        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);

    }

}
