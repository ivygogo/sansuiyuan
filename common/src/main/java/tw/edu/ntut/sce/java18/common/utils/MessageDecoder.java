package tw.edu.ntut.sce.java18.common.utils;

import com.google.gson.Gson;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;

public class MessageDecoder implements Decoder.Text<ChatMessageServiceBean> {

  @Override
  public ChatMessageServiceBean decode(String s) throws DecodeException {
    System.out.println("decode is start");
    Gson gson = new Gson();
    ChatMessageServiceBean message = gson.fromJson(s, ChatMessageServiceBean.class);
    return message;
  }

  @Override
  public boolean willDecode(String s) {
    return (s != null);
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
