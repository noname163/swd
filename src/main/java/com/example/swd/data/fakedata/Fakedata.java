package com.example.swd.data.fakedata;

import java.time.LocalDate;
import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import com.example.swd.data.repositories.*;
import com.github.javafaker.Faker;
import com.example.swd.data.entity.*;

@Configuration
public class Fakedata {
    @Bean
    CommandLineRunner initDatabase(LevelRepository levelRepository,
            QuestionRepository questionRepository, TargetRepository targetRepository,
            TargetDetailRepository targetDetailRepository, TestRepository testRepository,
            TestResultRepository testResultRepository, UserRepository userRepository,
            WrongAnswerRepository wrongAnswerRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Faker faker = new Faker();
                List<Level> levels = new ArrayList<>();
                levels.add(Level.builder().level(1)
                .maxGrade(5)
                .minGrade(4)
                .maxTime(2)
                .minTime(1)
                .build());
                levels.add(Level.builder().level(2)
                .maxGrade(8)
                .minGrade(7)
                .maxTime(3)
                .minTime(2)
                .build());
                levels.add(Level.builder().level(3)
                .maxGrade(10)
                .minGrade(9)
                .maxTime(6)
                .minTime(5)
                .build());
                // create some sample questions
                Question question1 = new Question();
                question1.setQuestion("What is the capital of France?");
                question1.setSubject("Geography");
                question1.setAnswer("Paris");

                Question question2 = new Question();
                question2.setQuestion("What is the largest planet in our solar system?");
                question2.setSubject("Astronomy");
                question2.setAnswer("Jupiter");

                Question question3 = new Question();
                question3.setQuestion("What is the smallest country in the world by land area?");
                question3.setSubject("Geography");
                question3.setAnswer("Vatican City");

                // create some wrong answers for the questions
                WrongAnswer wrongAnswer1 = new WrongAnswer();
                wrongAnswer1.setWrongAnswer("London");
                wrongAnswer1.setQuestion(question1);

                WrongAnswer wrongAnswer2 = new WrongAnswer();
                wrongAnswer2.setWrongAnswer("Mars");
                wrongAnswer2.setQuestion(question2);

                WrongAnswer wrongAnswer3 = new WrongAnswer();
                wrongAnswer3.setWrongAnswer("Monaco");
                wrongAnswer3.setQuestion(question3);

                // add the wrong answers to the questions
                List<WrongAnswer> wrongAnswers1 = new ArrayList<>();
                wrongAnswers1.add(wrongAnswer1);
                question1.setWrongAnswer(wrongAnswers1);

                List<WrongAnswer> wrongAnswers2 = new ArrayList<>();
                wrongAnswers2.add(wrongAnswer2);
                question2.setWrongAnswer(wrongAnswers2);

                List<WrongAnswer> wrongAnswers3 = new ArrayList<>();
                wrongAnswers3.add(wrongAnswer3);
                question3.setWrongAnswer(wrongAnswers3);

                List<Question> questionsGeo = new ArrayList<>();
                questionsGeo.add(question1);
                questionsGeo.add(question3);

                Question question4 = new Question();
                question4.setQuestion("What is the closest planet to the Sun?");
                question4.setSubject("Astronomy");
                question4.setAnswer("Mercury");

                WrongAnswer wrongAnswer4 = new WrongAnswer();
                wrongAnswer4.setWrongAnswer("Venus");
                wrongAnswer4.setQuestion(question4);

                WrongAnswer wrongAnswer5 = new WrongAnswer();
                wrongAnswer5.setWrongAnswer("Earth");
                wrongAnswer5.setQuestion(question4);

                WrongAnswer wrongAnswer6 = new WrongAnswer();
                wrongAnswer6.setWrongAnswer("Mars");
                wrongAnswer6.setQuestion(question4);

                List<WrongAnswer> wrongAnswers4 = new ArrayList<>();
                wrongAnswers4.add(wrongAnswer4);
                wrongAnswers4.add(wrongAnswer5);
                wrongAnswers4.add(wrongAnswer6);
                question4.setWrongAnswer(wrongAnswers4);

                Question question5 = new Question();
                question5.setQuestion("What is the name of the largest moon of Saturn?");
                question5.setSubject("Astronomy");
                question5.setAnswer("Titan");

                WrongAnswer wrongAnswer7 = new WrongAnswer();
                wrongAnswer7.setWrongAnswer("Europa");
                wrongAnswer7.setQuestion(question5);

                WrongAnswer wrongAnswer8 = new WrongAnswer();
                wrongAnswer8.setWrongAnswer("Enceladus");
                wrongAnswer8.setQuestion(question5);

                WrongAnswer wrongAnswer9 = new WrongAnswer();
                wrongAnswer9.setWrongAnswer("Ganymede");
                wrongAnswer9.setQuestion(question5);

                List<WrongAnswer> wrongAnswers5 = new ArrayList<>();
                wrongAnswers5.add(wrongAnswer7);
                wrongAnswers5.add(wrongAnswer8);
                wrongAnswers5.add(wrongAnswer9);
                question5.setWrongAnswer(wrongAnswers5);

                List<Question> questionAstromy = new ArrayList<>();
                questionAstromy.add(question5);
                questionAstromy.add(question2);
                questionAstromy.add(question4);

                Test test1 = new Test();
                test1.setCreateDate(LocalDate.now());
                test1.setSubject("Geography");
                test1.setQuestion(questionsGeo);
                Test test2 = new Test();
                test2.setCreateDate(LocalDate.now());
                test2.setSubject("Astronomy");
                test2.setQuestion(questionAstromy);

                // Create some sample users
                User user1 = new User();
                user1.setEmail("user1@example.com");
                user1.setUsername("user1");
                user1.setPassword("password1");
                user1.setCourse(1);

                User user2 = new User();
                user2.setEmail("user2@example.com");
                user2.setUsername("user2");
                user2.setPassword("password2");
                user2.setCourse(2);

                // Create a User object
                User user = User.builder()
                        .email("john.doe@example.com")
                        .username("johndoe")
                        .password("password")
                        .course(2)
                        .build();

                // Create two Target objects
                Target target1 = Target.builder()
                        .grade(7.5)
                        .process(60.0)
                        .group("Group A")
                        .major("Computer Science")
                        .user(user1)
                        .build();

                Target target2 = Target.builder()
                        .grade(8.0)
                        .process(75.0)
                        .group("Group B")
                        .major("Engineering")
                        .user(user1)
                        .build();

                // Add the two targets to the user's list of targets
                user1.setTarget(Arrays.asList(target1, target2));
                user2.setTarget(Arrays.asList(target2));

                // Create two TargetDetail objects for the first target
                TargetDetail targetDetail1 = TargetDetail.builder()
                        .grade(7.5)
                        .process(60.0)
                        .subject(test1.getSubject())
                        .major("Computer Science")
                        .user(user1)
                        .target(target1)
                        .build();

                TargetDetail targetDetail2 = TargetDetail.builder()
                        .grade(7.0)
                        .process(80.0)
                        .subject("Physics")
                        .major(test2.getSubject())
                        .user(user1)
                        .target(target1)
                        .build();

                // Add the two target details to the first target's list of target details
                target1.setTargetDetail(Arrays.asList(targetDetail1, targetDetail2));

                // Create one TargetDetail object for the second target
                TargetDetail targetDetail3 = TargetDetail.builder()
                        .grade(8.0)
                        .process(75.0)
                        .subject(test1.getSubject())
                        .major("Engineering")
                        .user(user2)
                        .target(target2)
                        .build();

                // Add the target detail to the second target's list of target details
                target2.setTargetDetail(Collections.singletonList(targetDetail3));

                // Create some sample test results
                TestResult testResult1 = new TestResult();
                testResult1.setGrade(80.0);
                testResult1.setSubject(test1.getSubject());
                testResult1.setTest(test1);

                TestResult testResult2 = new TestResult();
                testResult2.setGrade(90.0);
                testResult2.setSubject(test2.getSubject());
                testResult2.setTest(test2);

                TestResult testResult3 = new TestResult();
                testResult3.setGrade(75.0);
                testResult3.setSubject(test1.getSubject());
                testResult3.setTest(test1);

                TestResult testResult4 = new TestResult();
                testResult4.setGrade(85.0);
                testResult4.setSubject(test2.getSubject());
                testResult4.setTest(test2);

                // Add the test results to the users
                List<TestResult> testResults1 = new ArrayList<>();
                testResults1.add(testResult1);
                testResults1.add(testResult2);
                user1.setTestResult(testResults1);

                List<TestResult> testResults2 = new ArrayList<>();
                testResults2.add(testResult3);
                testResults2.add(testResult4);
                user2.setTestResult(testResults2);

                questionRepository.saveAll(questionAstromy);
                questionRepository.saveAll(questionsGeo);

                wrongAnswerRepository.saveAll(wrongAnswers1);
                wrongAnswerRepository.saveAll(wrongAnswers2);
                wrongAnswerRepository.saveAll(wrongAnswers3);
                wrongAnswerRepository.saveAll(wrongAnswers4);

                testRepository.save(test1);
                testRepository.save(test2);

                testResultRepository.saveAll(testResults1);
                testResultRepository.saveAll(testResults2);

                
                userRepository.save(user1);
                userRepository.save(user2);
                
                targetRepository.save(target1);
                targetRepository.save(target2);

                targetDetailRepository.save(targetDetail1);
                targetDetailRepository.save(targetDetail2);
                targetDetailRepository.save(targetDetail3);

                levelRepository.saveAll(levels);
            }
        };
    }
}
