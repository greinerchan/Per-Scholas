import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		sendTextFile(response, "HW1.html", null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valueX = request.getParameter("valueX");
		String valueY = request.getParameter("valueY");
		String operator = request.getParameter("operator");
		StringBuilder valueX1= new StringBuilder();
		StringBuilder valueY1= new StringBuilder();
		double answer;
		String output = null;
		List<String> output2 = new ArrayList<String>();
		boolean validInput = true;
		Map<String, StringBuilder> context = new HashMap<String,StringBuilder>();
		valueX1.append(valueX);
		valueY1.append(valueY);
		if (operator == null && valueX != null && valueY != null) {
			StringBuilder s = new StringBuilder();
			s.append(("Missing Operator Parameter"));
			context.put("$X$", valueX1);
			context.put("$Y$", valueY1);
			context.put("$Ans$", s);
			sendTextFile(response, "result.html", context);
			return;
		}
		if (valueX == null) {
			StringBuilder s = new StringBuilder();
			StringBuilder x = new StringBuilder();
			StringBuilder y = new StringBuilder();
			s.append(("Missing X Parameter"));
			x.append("0");
			y.append("0");
			context.put("$X$", x);
			context.put("$Y$", y);
			context.put("$Ans$", s);
			sendTextFile(response, "result.html", context);
			return;
		} 
		if (valueY == null) {
			StringBuilder s = new StringBuilder();
			StringBuilder x = new StringBuilder();
			StringBuilder y = new StringBuilder();
			s.append(("Missing Y Parameter"));
			x.append("0");
			y.append("0");
			context.put("$X$", x);
			context.put("$Y$", y);
			context.put("$Ans$", s);
			sendTextFile(response, "result.html", context);
			return;
		}
		if (checkEmpty(valueX)) {
			output2.add("The Input X is Empty");		
		}
		if (!checkNumber(valueX)) {
			output2.add("The Input X is Not A Number");

		}
		if (checkEmpty(valueY)) {
			output2.add("The Input Y is Empty");
		}
		if (!checkNumber(valueY)) {
			output2.add("The Input Y is Not A Number");
		}
		if (checkNumber(valueY) && checkNumber(valueX) 
				&& (!checkEmpty(valueY)) && (!checkEmpty(valueX))) {
			validInput = true;
		} else {
			validInput = false;
		}
		if (operator.equals("/") && (!checkEmpty(valueY)) 
				&& checkNumber(valueY)) {
			if(Double.valueOf(valueY) == 0) {
				output2.add("Divider Can Not Be Zero");
				validInput = false;
			}
		}
		if (operator.equals("+") && validInput) {
			answer = Double.parseDouble(valueX) + Double.parseDouble(valueY);
			output = ansFormat(answer);
		} else if (operator.equals("-") && validInput) {
			answer = Double.parseDouble(valueX) - Double.parseDouble(valueY);
			output = ansFormat(answer);
		} else if (operator.equals("*") && validInput) {
			answer = Double.parseDouble(valueX) * Double.parseDouble(valueY);
			output = ansFormat(answer);
		} else if (operator.equals("/") && (!checkEmpty(valueY)) 
				&& checkNumber(valueY) && checkNumber(valueX)) {
			if(Double.valueOf(valueY) != 0) {
				answer = Double.parseDouble(valueX) / Double.parseDouble(valueY);
				output = ansFormat(answer);
			}
		} else if (!operator.equals("+") && !operator.equals("-") 
				&& !operator.equals("*") && !operator.equals("/")) {
			output2.add("Not a Valid Operator");
		}
		context.put("$X$", valueX1);
		context.put("$Y$", valueY1);
		if (output2.isEmpty()) {
			StringBuilder output3 = new StringBuilder();
			output3.append(ansFormat(Double.valueOf(valueX))).append("  ").append(operator)
					.append("  ").append(ansFormat(Double.valueOf(valueY))).append("  ")
					.append("=").append("  ").append(output);
			context.put("$Ans$", output3);
		} else {
			StringBuilder s = new StringBuilder();
			for (String a : output2) {
				s.append(a).append("<br>");
			}
			context.put("$Ans$", s);
		}

		sendTextFile(response, "result.html", context);
	}
	private boolean checkEmpty(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		} 
		return false;
	}
	private boolean checkNumber(String s) {
        if (!checkEmpty(s)) {
	        try {
	            Double.valueOf(s);
	        } catch (Exception e) {
	            return false;
	        }
	        return true;
		}
        return true;
	}
	private String ansFormat(double answer) {
		NumberFormat df1 = new DecimalFormat("#,##0.00");
		return df1.format(answer);
	}
	private String insertContext(String html, Map<String, StringBuilder> context) {
		StringBuilder b = new StringBuilder(html);
		for (String key : context.keySet()) {
			int startPos = b.indexOf(key);
			int endPos = startPos + key.length();
			StringBuilder value = context.get(key);
			String value1 = value + ""; 
			b.replace(startPos, endPos, value1);
		}
		return b.toString();
	}
	

    private void sendTextFile(HttpServletResponse response, String fileName, Map<String, StringBuilder> context)
            throws IOException {
	
	    	InputStream is = getServletContext().getResourceAsStream("/content/" + fileName);
	    if (is == null) {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        return;
	    }
	

        String originalHtml = streamToString(is);

        	if (context == null) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(originalHtml);
            return;
        	}
        	
	    String updatedHtml = insertContext(originalHtml, context);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(updatedHtml);
    }

    private String streamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            StringBuilder b = new StringBuilder();

            String line = br.readLine();
            while (line != null) {
                b.append(line);
                b.append('\n');
                line = br.readLine();
            }

            return b.toString();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
