import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(DataController.class)
public class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataRepository dataRepository;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
        // Set up MockMvc with the DataController
        mockMvc = MockMvcBuilders.standaloneSetup(new DataController(dataRepository)).build();
    }

    @Test
    public void testGetData() throws Exception {
        // Prepare mock data
        List<DataModel> dataList = Arrays.asList(
            new DataModel(1L, "Sample Data 1", "Description 1"),
            new DataModel(2L, "Sample Data 2", "Description 2")
        );

        // Mock the behavior of dataRepository.findAll()
        when(dataRepository.findAll()).thenReturn(dataList);

        // Perform GET request and verify the response
        mockMvc.perform(get("/data"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].name").value("Sample Data 1"))
            .andExpect(jsonPath("$[1].id").value(2L))
            .andExpect(jsonPath("$[1].name").value("Sample Data 2"));
    }

    @Test
    public void testGetDataById() throws Exception {
        // Prepare mock data
        DataModel data = new DataModel(1L, "Sample Data 1", "Description 1");

        // Mock the behavior of dataRepository.findById()
        when(dataRepository.findById(1L)).thenReturn(Optional.of(data));

        // Perform GET request and verify the response
        mockMvc.perform(get("/data/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value("Sample Data 1"));
    }
}
