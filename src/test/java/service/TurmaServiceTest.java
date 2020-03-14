package service;

import com.curso.api_curso.domains.Aluno;
import com.curso.api_curso.domains.Curso;
import com.curso.api_curso.domains.Matricula;
import com.curso.api_curso.domains.Turma;
import com.curso.api_curso.dtos.TurmaDTO;
import com.curso.api_curso.repository.TurmaRepository;
import com.curso.api_curso.service.CursoService;
import com.curso.api_curso.service.MatriculaService;
import com.curso.api_curso.service.TurmaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TurmaServiceTest {


    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private CursoService cursoService;

    @Mock
    private MatriculaService matriculaService;

    @InjectMocks
    private TurmaService turmaService;

    @BeforeEach
    public void setUp(){
        this.turmaRepository = Mockito.mock(TurmaRepository.class);
    }


        @Test
        void testSalvarComSucesso() {
            // entrada
            TurmaDTO turmaDTO = new TurmaDTO( 1l, "27/05/2020",
                    "27/05/2021", Arrays.asList(1L, 2L, 3L, 4L));

            Curso curso = new Curso();
            List<Aluno> alunos = Arrays.asList(new Aluno());
            List<Matricula> matriculas = Arrays.asList(new Matricula());
            Turma turma = new Turma(turmaDTO.getDataInicio(),
                    turmaDTO.getDatafinal(), curso);

            when(cursoService.findById(turmaDTO.getIdCurso())).thenReturn(curso);
            when(turmaRepository.save(turma)).thenReturn(turma);

            // execução
            Turma atual = turmaService.salvar(turmaDTO);

            // verificação
            assertEquals(turma, atual);
            verify(cursoService, times(1)).findById(turmaDTO.getIdCurso());
            verify(turmaRepository).save(turma);
            verify(matriculaService).save(turma, turmaDTO.getIdAlunos());

    }


        @Test
    void falhaSalvarSemDataInicio(){

        Turma esperado = new Turma(null,"23/11/2020");

        TurmaService turmaService = new TurmaService(turmaRepository);
        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            turmaService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(turmaRepository);


    }

     @Test
    void falhaSalvarSemDatafinal(){

        Turma esperado = new Turma("16/11/1995",null);

        TurmaService turmaService = new TurmaService(turmaRepository);
        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            turmaService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(turmaRepository);


    }

}
