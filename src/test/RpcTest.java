import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.domaindto.Application;
import ru.geekbrains.oldapp.model.OldModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 15.11.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class RpcTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("id", "0");
        req_payload.put("method", "oldMethod");

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);

        ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8080/oldApp/rpc/oldService", request, String.class );
        System.out.println(response.getBody());
        OldModel oldModel = objectMapper.readValue(response.getBody(), OldModel.class);
        Assert.assertEquals("Все плохо", 1, oldModel.getA());
    }
}
