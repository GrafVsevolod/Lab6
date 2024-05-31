package network;

import java.io.Serial;
import java.io.Serializable;

public class Response implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433500L;
    private String result = "\nSuccess\n";

    public void setResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public Response(String result){
        this.result = result;
    }
}
