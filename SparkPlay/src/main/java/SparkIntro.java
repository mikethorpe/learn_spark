import java.util.ArrayList;
import java.util.Collections;

import static spark.Spark.get;

public class SparkIntro {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<>();
		names.add("Mike");
		names.add("Joanna");
		names.add("Garry");


		get("/hello/:name", (req, res) ->
			{
				return "Hello " + req.params(":name");
			}
		);


		get("/randomname", (req, res) ->
			{
				Collections.shuffle(names);
				return names.get(0);
			}
		);

		get("/friends/:id", (req, res) -> {
			String[] friends = {"Joanna", "Gary", "Beata", "Digory"};
			int index = Integer.parseInt(req.params("id")) - 1;
			return friends[index];

		});

		get("/add/:num1/:num2", (req, res) -> {
				return Integer.parseInt(req.params("num1")) + Integer.parseInt(req.params("num2"));
		});

	}
}
