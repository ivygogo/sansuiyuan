package tw.edu.ntut.sce.java18.common.utils;

import com.google.gson.Gson;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;

public class MessageEncoder implements Encoder.Text<ChatMessageServiceBean> {

  @Override
  public String encode(ChatMessageServiceBean message) throws EncodeException {
    System.out.println("encode is start");
    Gson gson = new Gson();
    String json = gson.toJson(message);
    return json;
  }

  @Override
  public void init(EndpointConfig endpointConfig) {
    // Custom initialization logic
  }

  @Override
  public void destroy() {
    // Close resources
  }
}
