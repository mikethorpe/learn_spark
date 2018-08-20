import models.Calculator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Controller {
    public static void main(String[] args) {

    	VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/add/:num1/:num2", (req, res) -> {
				Integer number1 = Integer.parseInt(req.params(":num1"));
				Integer number2 = Integer.parseInt(req.params(":num2"));
				Calculator calculator = new Calculator(number1, number2);
				int result = calculator.add();
				Map<String, Object> model = new HashMap();
				model.put("result", result);
				model.put("num1", number1);
				model.put("num2", number2);

				return new ModelAndView(model, "AddResult.vtl");
        	},
			velocityTemplateEngine
		);

        get("/subtract/:num1/:num2", (req, res) -> {
            Integer number1 = Integer.parseInt(req.params(":num1"));
            Integer number2 = Integer.parseInt(req.params(":num2"));
            Calculator calculator = new Calculator(number1, number2);
            int result = calculator.subtract();
            Map<String, Object> model = new HashMap<>();
			model.put("result", result);
			model.put("num1", number1);
			model.put("num2", number2);

			return new ModelAndView(model, "SubtractResult.vtl");
        },
        	velocityTemplateEngine
        );

        get("/multiply/:num1/:num2", (req, res) -> {
            Integer number1 = Integer.parseInt(req.params(":num1"));
            Integer number2 = Integer.parseInt(req.params(":num2"));
            Calculator calculator = new Calculator(number1, number2);
            int result = calculator.multiply();
			Map<String, Object> model = new HashMap<>();
			model.put("result", result);
			model.put("num1", number1);
			model.put("num2", number2);
            return new ModelAndView(model, "MultiplyResult.vtl");
        },
        	velocityTemplateEngine
        );

        get("/divide/:num1/:num2", (req, res) -> {
            Integer number1 = Integer.parseInt(req.params(":num1"));
            Integer number2 = Integer.parseInt(req.params(":num2"));
            Calculator calculator = new Calculator(number1, number2);
            double result = calculator.divide();
			Map<String, Object> model = new HashMap<>();
			model.put("result", result);
			model.put("num1", number1);
			model.put("num2", number2);
			return new ModelAndView(model, "DivideResult.vtl");
        },
        	velocityTemplateEngine
        );
    }
}
