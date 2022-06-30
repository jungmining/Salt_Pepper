package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.min.edu.model.AnimalDaoImpl;
import com.min.edu.model.IAnimalDao;
import com.min.edu.vo.AnimalHospitalDto;

public class AnimalHospitalController extends HttpServlet {

	private static final long serialVersionUID = 5622509602020453687L;
//	private Logger logger = Logger.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/animalHospital.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8;");
		String command = req.getParameter("command");
		System.out.println("command 값 들어오는지 : "+command);
//		logger.info("command 값 들어오는지 : "+command);
		
		if(command.trim().equalsIgnoreCase("db")) {
			String[] animalList = req.getParameterValues("animal");
	//		System.out.println(Arrays.toString(animalList));//
			List<AnimalHospitalDto> dtos = new ArrayList<AnimalHospitalDto>();
			for(int i=0; i<animalList.length; i++) {
				String[] temp = animalList[i].split("&");
				System.out.println(animalList.length);
				System.out.println(temp.length);
					int idx = temp.length;
					for(int j =0; j<idx; j++) {
						if(temp[j++].trim().equalsIgnoreCase("null")) {
							temp[j++] = "0";
						}else if(temp[j++].trim().equals("")) {
							temp[j++] = "0";
						}
						
						AnimalHospitalDto dto = new AnimalHospitalDto(temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++], temp[j++]);
						dtos.add(dto);
						
					}
					
				
//				try {
//				} catch (Exception e) {
//					if(temp[idx].trim().equalsIgnoreCase("null")) {
//						temp[idx] = "0";
//					}else if(temp[idx].trim().equals("")) {
//						temp[idx] = "0";
//					}
//					e.printStackTrace();
//				}
			}
//			logger.info(dtos);
//			logger.info(dtos.size());
			IAnimalDao dao = new AnimalDaoImpl();
			int cnt = dao.animalHospitalInsert(dtos);
		if(cnt>0) {
				System.out.println("DB저장에 성공하였습니다");
////				logger.info("DB저장에 성공하였습니다");
		}else {
////				logger.info("DB저장에 실패하였습니다");
			}
		}
		
		
/*		
		if(command.trim().equalsIgnoreCase("db2")){
//			logger.info("db들어오는지 확인");
			String jsonObj = req.getParameter("obj");
//			//String jsonObjb = req.getParameter("b");
//			logger.info("jsonObjb 값 :"+jsonObj);
			JsonElement ele = JsonParser.parseString(jsonObj);
			int len = ele.getAsJsonObject().get("DATA").getAsJsonArray().size();

			List<AnimalHospitalDto> dtos = new ArrayList<AnimalHospitalDto>();
			for(int i=0; i<len; i++) {
				JsonObject temp = ele.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				JsonElement t1 = temp.get("sitepostno");
				JsonElement t2 = temp.get("rgtmbdsno");
				JsonElement t3 = temp.get("totepnum");
				JsonElement t4 = temp.get("uptaenm");
				JsonElement t5 = temp.get("lastmodts");
				JsonElement t6 = temp.get("clgenddt");
				JsonElement t7 = temp.get("updategbn");
				JsonElement t8 = temp.get("rdnwhladdr");
				JsonElement t9 = temp.get("dcbymd");
				JsonElement t10 = temp.get("sitewhladdr");
				JsonElement t11 = temp.get("y");
				JsonElement t12 = temp.get("dtlstategbn");
				JsonElement t13 = temp.get("trdstategbn");
				JsonElement t14 = temp.get("x");
				JsonElement t15 = temp.get("opnsfteamcode");
				JsonElement t16 = temp.get("apvpermymd");
				JsonElement t17 = temp.get("lindseqno");
				JsonElement t18 = temp.get("updatedt");
				JsonElement t19 = temp.get("lindprcbgbnnm");
				JsonElement t20 = temp.get("bplcnm");
				JsonElement t21 = temp.get("clgstdt");
				JsonElement t22 = temp.get("rdnpostno");
				JsonElement t23 = temp.get("ropnymd");
				JsonElement t24 = temp.get("mgtno");
				JsonElement t25 = temp.get("lindjobgbnnm");
				JsonElement t26 = temp.get("trdstatenm");
				JsonElement t27 = temp.get("sitearea");
				JsonElement t28 = temp.get("sitetel");
				JsonElement t29 = temp.get("apvcancelymd");
				JsonElement t30 = temp.get("dtlstatenm");
				
				if((t1.equals("null")||t1.equals(""))||(t2.equals("null")||t2.equals(""))||(t3.equals("null")||t3.equals(""))||(t4.equals("null")||t4.equals(""))||(t5.equals("null")||t5.equals(""))||(t6.equals("null")||t6.equals(""))||(t7.equals("null")||t7.equals(""))||(t8.equals("null")||t8.equals(""))||(t9.equals("null")||t9.equals(""))||(t10.equals("null")||t10.equals(""))||(t11.equals("null")||t11.equals(""))||(t12.equals("null")||t12.equals(""))||(t13.equals("null")||t13.equals(""))||(t14.equals("null")||t14.equals(""))||(t15.equals("null")||t15.equals(""))||(t16.equals("null")||t16.equals(""))||(t17.equals("null")||t17.equals(""))||(t18.equals("null")||t18.equals(""))||(t19.equals("null")||t19.equals(""))||(t20.equals("null")||t20.equals(""))||(t21.equals("null")||t21.equals(""))||(t22.equals("null")||t22.equals(""))||(t23.equals("null")||t23.equals(""))||(t24.equals("null")||t24.equals(""))||(t25.equals("null")||t25.equals(""))||(t26.equals("null")||t26.equals(""))||(t27.equals("null")||t27.equals(""))||(t28.equals("null")||t28.equals(""))||(t29.equals("null")||t29.equals(""))||(t30.equals("null")||t30.equals(""))) {
					t1 = JsonParser.parseString("0");
					t2 = JsonParser.parseString("0");
					t3 = JsonParser.parseString("0");
					t4 = JsonParser.parseString("0");
					t5 = JsonParser.parseString("0");
					t6 = JsonParser.parseString("0");
					t7 = JsonParser.parseString("0");
					t8 = JsonParser.parseString("0");
					t9 = JsonParser.parseString("0");
					t10 = JsonParser.parseString("0");
					t11 = JsonParser.parseString("0");
					t12 = JsonParser.parseString("0");
					t13 = JsonParser.parseString("0");
					t14 = JsonParser.parseString("0");
					t15 = JsonParser.parseString("0");
					t16 = JsonParser.parseString("0");
					t17 = JsonParser.parseString("0");
					t18 = JsonParser.parseString("0");
					t19 = JsonParser.parseString("0");
					t20 = JsonParser.parseString("0");
					t21 = JsonParser.parseString("0");
					t22 = JsonParser.parseString("0");
					t23 = JsonParser.parseString("0");
					t24 = JsonParser.parseString("0");
					t25 = JsonParser.parseString("0");
					t26 = JsonParser.parseString("0");
					t27 = JsonParser.parseString("0");
					t28 = JsonParser.parseString("0");
					t29 = JsonParser.parseString("0");
					t30 = JsonParser.parseString("0");
				}
				AnimalHospitalDto dto = new AnimalHospitalDto(t1.getAsInt(), t2.getAsInt(), t3.getAsInt(), t4.getAsInt(), t5.getAsInt(), t6.getAsInt(), t7.getAsString(), t8.getAsString(), t9.getAsInt(), t10.getAsString(), t11.getAsDouble(), t12.getAsInt(), t13.getAsInt(), t14.getAsDouble(), t15.getAsInt(), t16.getAsInt(), t17.getAsInt(), t18.getAsString(), t19.getAsString(), t20.getAsString(), t21.getAsInt(), t22.getAsInt(), t23.getAsInt(), t24.getAsInt(), t25.getAsString(), t26.getAsString(), t27.getAsDouble(), t28.getAsInt(), t29.getAsInt(), t30.getAsString());
				dtos.add(dto);
		}
			IAnimalDao dao = new AnimalDaoImpl();
			dao.animalHospitalDelete();
			int n = dao.animalHospitalInsert(dtos);
			if(n>0) {
				System.out.println("DB입력 성공");
		}else {
				System.out.println("DB입력 실패");
		}
//			resp.getWriter().print(n);
//		
			
		}
*/
	}
}
