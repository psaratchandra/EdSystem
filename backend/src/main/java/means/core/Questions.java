package means.core;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Questions {

	@JsonProperty
	@NotEmpty
	public int id;
	
	@JsonProperty
	@NotEmpty
	public String question;
	
	@JsonProperty
	@NotEmpty
	public String option1;
	
	@JsonProperty
	@NotEmpty
	public String option2;
	
	@JsonProperty
	@NotEmpty
	public String option3;
	
	@JsonProperty
	@NotEmpty
	public String option4;
	
	/*@JsonProperty
	@NotEmpty
	public List<String> answer = new ArrayList<>();*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	
	
	
	/*public List<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	public void addAnswer(String answer) {
		this.answer.add(answer);
	}
	public String getFullQuestion() {
		return this.id+" "+this.question+" "+this.answer;
	}*/
}