package serialization_2;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Serialize_To_JSON_Request 
{
	@Test
	public void serialize_to_json() throws JsonProcessingException
	{
		Bakery bky = new Bakery();
		bky.setId("1");
		bky.setType("Regulat");
		bky.setName("Cadbury's");
		bky.setPpu(0.99);
		
		Batter b1 = new Batter("1001","Regular");
		Batter b2 = new Batter("1002","Chocolate");
		Batter b3 = new Batter("1003","Blueberry");
		Batter b4 = new Batter("1003","Devil's Food");
		List<Batter> a = new ArrayList<Batter>();
		a.add(b1);
		a.add(b2);
		a.add(b3);
		a.add(b4);
		
		Batters bt1 = new Batters();
		bt1.setBatter(a);
		
		Topping t1 = new Topping("5001", "None");
		Topping t2 = new Topping("5002", "Glazed");
		Topping t3 = new Topping("5005", "Sugar");
		Topping t4 = new Topping("5007", "Powdered Sugar");
		Topping t5 = new Topping("5006", "Chocolate with Sprinkles");
		Topping t6 = new Topping("5003", "Chocolate");
		Topping t7 = new Topping("5004", "Maple");
		List<Topping> t = new ArrayList<Topping>();
		t.add(t1);
		t.add(t2);
		t.add(t3);
		t.add(t4);
		t.add(t5);
		t.add(t6);
		t.add(t7);
		bky.setBatters(bt1);
		bky.setTopping(t);
		
		////////////////////////////////////////////////////////////
		Bakery bky2 = new Bakery();
		bky2.setId("1");
		bky2.setType("Regulat");
		bky2.setName("Cadbury's");
		bky2.setPpu(0.99);
		
		Batter b11 = new Batter("1001","Regular");
		List<Batter> a1 = new ArrayList<Batter>();
		a1.add(b11);
		Batters bt2 = new Batters();
		bt2.setBatter(a1);
		
		Topping t11 = new Topping("5001", "None");
		Topping t21 = new Topping("5002", "Glazed");
		Topping t31 = new Topping("5005", "Sugar");
		Topping t61 = new Topping("5003", "Chocolate");
		Topping t71 = new Topping("5004", "Maple");
		
		List<Topping> tt = new ArrayList<Topping>();
		tt.add(t11);
		tt.add(t21);
		tt.add(t31);
		tt.add(t61);
		tt.add(t71);
		
		bky2.setBatters(bt2);
		bky2.setTopping(tt);
		
		////////////////////////////////////////////////
		
		
		Bakery bky3 = new Bakery();
		bky3.setId("1");
		bky3.setType("Regulat");
		bky3.setName("Cadbury's");
		bky3.setPpu(0.99);
		
		Batter b111 = new Batter("1001","Regular");
		Batter b112 = new Batter("1002","Chocolate");
		List<Batter> a3 = new ArrayList<Batter>();
		a3.add(b111);
		a3.add(b112);
		Batters bt3 = new Batters();
		bt3.setBatter(a3);
		
		Topping tt1 = new Topping("5001", "None");
		Topping tt2 = new Topping("5002", "Glazed");
		Topping tt4 = new Topping("5003", "Chocolate");
		Topping tt5 = new Topping("5004", "Maple");
		
		List<Topping> ttt = new ArrayList<Topping>();
		ttt.add(tt1);
		ttt.add(tt2);
		ttt.add(tt4);
		ttt.add(tt5);
		bky3.setBatters(bt3);
		bky3.setTopping(ttt);
		
		List<Bakery> arLt = new ArrayList<Bakery>();
		arLt.add(bky);
		arLt.add(bky2);
		arLt.add(bky3);
		
		ObjectMapper mapper = new ObjectMapper();
		String resp = mapper.writeValueAsString(arLt);
		System.out.println(resp);
		
		/*
		 * List<Integer> iii = new ArrayList<Integer>(); iii.add(100); iii.add(200);
		 * String kkk = mapper.writeValueAsString(iii); System.out.println(kkk);
		 */
	}
}
