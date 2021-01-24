package com.accolite.assignment.assign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accolite.assignment.assign.entity.Answear;
import com.accolite.assignment.assign.entity.Options;
import com.accolite.assignment.assign.entity.Quiz;
import com.accolite.assignment.assign.entity.School;
import com.accolite.assignment.assign.repository.AnswearJPARespository;
import com.accolite.assignment.assign.repository.QuestionJPARepository;
import com.accolite.assignment.assign.repository.SchoolJPA;

/*
 * Main clas for execution 
 * 
 */
@SpringBootApplication
@Transactional
public class AssignApplication implements CommandLineRunner {
  
	
	// SchoolJPA class is used for save data or query type result 
	 @Autowired
	 SchoolJPA schooljpa; 
	 
	 @Autowired
	 AnswearJPARespository answearRepo;
	 
	 @Autowired
	 QuestionJPARepository questionRepo;

	 
	 // BufferReader is used to handle inputs mostly string inputs some places scanner nextLine() show some abnormal behaviour 
	 static BufferedReader input;
	 // scanner used for handle inputs
	 static Scanner sc;
	 
	 
	public static void main(String[] args) {
		
		    sc = new Scanner(System.in);
			input = new BufferedReader(new InputStreamReader(System.in));
		SpringApplication.run(AssignApplication.class, args);
	
		
	
	}
  // generateQuestion method take question statement , options and Right answear and return quiz object i.e question 
	public static Quiz generateQuestion(String correctOption,String opt1,String opt2,String opt3,String opt4,String question) {
		Answear ans = createOjectOfAnswear(correctOption);
		Options option = createObjectofOptions(opt1,opt2,opt3,opt4,ans);
		Quiz question1 = createObjectofQuiz(question,option);
		return question1;
	}
	
	
 // set answear of the question 
  public static	Answear createOjectOfAnswear(String rightOption) {
	  
	  Answear ans = new Answear();
	  
	  ans.setRightOption(rightOption);
	  
	  return ans;
 }
  
  // store options corresponding to question and set right answear 
	 public static Options createObjectofOptions(String opt1,String opt2,String opt3,String opt4,Answear ans) {
		 Options option = new Options();
		 option.setA(opt1);
		 option.setB(opt2);
		 option.setC(opt3);
		 option.setD(opt4);
		 option.setAnswear(ans);
		 return option;
		}

	// creating question with set all options and question
	public static Quiz createObjectofQuiz(String question,Options option) {
		 Quiz quiz = new Quiz();
		 quiz.setQuestion(question);
		 quiz.setOptions(option);
		 return quiz;
	 }
	
	// creating object of school with name and assign question set  
	 public static School createObjectofSchool(String name,Set<Quiz> questionSet) {
		 School school = new School();
		 school.setName(name);
		 school.setQuizs(questionSet);
		 return school;
	 }
	// show the answear list of the all the question  with question Id 
	public static void showAnswearSheet( AnswearJPARespository answearRepo) {
		List<Answear> answearSheet  = answearRepo.findAll();
		System.out.println("Question ID \t Correct Option");
		answearSheet.forEach(item->{
			System.out.println(item.getId() + "\t\t" + item.getRightOption() );
			
		});
	}
	
	// show all the question in the table withs options
	public static void showQuestionSheet(QuestionJPARepository questionRepo) {
		List<Quiz> questionSheet = questionRepo.findAll();
		
		questionSheet.forEach(question->{
			String questionStatement = "Question Statement \n" +question.getId() + " : " + question.getQuestion();
			System.out.println(questionStatement);
			
			Options opt = question.getOptions();
			String options = "options : " + " A : " + opt.getA() + " B : " + opt.getB() + 
										   " C : " + opt.getC() + " D : " + opt.getD();
			System.out.println(options);
			});
		
	}
	
	// setQuestion is method is used to generate/make question with options and right answear 
	// and assign question set to a particular school with school name
	public static School  setQuestions() throws IOException {
		
		System.out.println("Enter Number of questions wants to generate");
		int questionNumber = sc.nextInt();
		Set<Quiz> questionSet = new HashSet<>();
		while(questionNumber>0) {
			
			System.out.println("Enter Question statement");
			String questionStatement = input.readLine();
			System.out.println("Enter option A");
			String opt1 = input.readLine();
			System.out.println("Enter option B");
			String opt2 = input.readLine();
			System.out.println("Enter option C");
			String opt3 = input.readLine();
			System.out.println("Enter option D");
			String opt4 = input.readLine();
			System.out.println("Enter correct Option");
			String correctOption = input.readLine();
			
			Quiz ques = generateQuestion(correctOption,opt1,opt2,opt3,opt4, questionStatement );
			questionSet.add(ques);
			questionNumber--;
		}
		System.out.println("Enter School Name assign question paper");
		String schoolName = input.readLine();
		School school = createObjectofSchool(schoolName,questionSet);
	  return  school;
	}

	
/* 
 *  gives Multiple options to perform task like create question set, check all the question , check answearsheet with question id
 *  save into database table , find , delete 
 *  enter 0 for teminate execution of  do wile loop
 *  
  */
	
		@Override
		public void run(String... args) throws Exception {
			Integer operation = 0;
			School school = null;
         do {
			
        	 System.out.println("\n");
			System.out.println("Enter 1 for question set generate");
			System.out.println("Enter 2 for check Available Questions");
			System.out.println("Enter 3 for AnswearSheet coressponding question ID");
			System.out.println("Enter 4 for Save question Set to school");
			System.out.println("Enter 5 for Find School by ID");
			System.out.println("Enter 6 for Delete Schhol by ID");
			System.out.println("Enter 0 for Exit");
			System.out.println("\n");
			try {
				operation = sc.nextInt();
			}catch(Exception e) {
				System.out.println("Input must be Numberic Value");
				break;
			}
			
			
			switch(operation) {
			case 1:{
				     school =  setQuestions();
				break;
			}
			case 2:{
				showQuestionSheet(questionRepo);
				break;
			}
			case 3:{
				 showAnswearSheet(answearRepo);
				break;
				
			}
			case 4:{
				if(school!=null) {
				schooljpa.save(school);
				System.out.println("Data Save into database table");
				 }
				else System.out.println("First assign question set to school for save select option 1");
				break;
			}
			case 5:{
				System.out.println("Enter id for find details of the shool");
				int id = sc.nextInt();
				School sc = schooljpa.findById(id);
				
				System.out.println("Schhol id " + sc.getId() + " School name " + sc.getName());
				break;
			}
			case 6:{
				System.out.println("Enter id for delete  the shool Detials");
				int id = sc.nextInt();
				schooljpa.deleteById(id);
				break;
			}
			
			default :{
				if(operation!=0)
				System.err.println("---------opps wrong input ---------");
			}
			
			}
         }while(operation !=0 );
         
       System.out.println("---------While Execution Complete---------");
		}
		
}
