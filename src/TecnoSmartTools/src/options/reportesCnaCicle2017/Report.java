package options.reportesCnaCicle2017;


import java.util.HashMap;
import java.util.List;

public interface Report<T> {
	 public List<T> getAllDataFromList(HashMap<String, Object> params)throws Exception;
}
