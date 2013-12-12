package es.rchavarria.library.rest.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static es.rchavarria.library.rest.controller.fixture.RESTDataFixture.allLevels;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rchavarria.library.core.service.LevelService;
import es.rchavarria.library.rest.controller.LevelQueriesController;

public class LevelQueriesControllerTest {

    @InjectMocks
    LevelQueriesController controller;

    @Mock
    LevelService levelService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCourseLevelsUsesLevelService() throws Exception {
        when(levelService.requestAllCourseLevels()).thenReturn(allLevels());

        controller.getAllLevels();

        verify(levelService, times(1)).requestAllCourseLevels();
    }

}
