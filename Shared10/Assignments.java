
https://github.com/techhue/JEDIJune2020


DAY 01
__________________________________________________________________

	Reading and Practice Assignment
	______________________________________________________________
		Reference Book
			Linux Pocket Guide, Orielly Publication
				Pages 11 To 29
				Pages 37 to 70

DAY 02
__________________________________________________________________
	Reading and Practice Assignment
	______________________________________________________________
		Reference Book
			Linux Pocket Guide, Orielly Publication
				Pages 71 to 95
				Pages 104 to 114


DAY 03
__________________________________________________________________
	Reading and Practice Assignment
	______________________________________________________________
		GIT Reference Notes
			GP.01.GettingStarted.pdf
			GP.02.GitBasics.pdf
			GP.03.GitBranching.pdf
			GP.05.DistributedGit.pdf
			GP.08.CustomizingGit.pdf

			SuccessfulGitBranchingModel.pdf

DAY 04
__________________________________________________________________
	A1. Coding And Practice Examples
	______________________________________________________________
		Till Today Code Examples Practice and Study

	A2. Reading Assignments and Code Practice Assignments
	______________________________________________________________
		Reference Book : Java Complete Reference, 8th Edition
		Read Following Chapters
			1. Data Types, Variables and Arrays
			2. Operators
			3. Control Statements

	A3. Coding Assignments
	______________________________________________________________
		Write Program In C To Calculate Factorial of Any Large N.
			Without Using Any Libraries.

	A4. Exploration Assignments
	______________________________________________________________
		What is The Definition of Modulus Operator in Mathematics?
		Compare Working of Modulus Operator in C, C++ and Java with Mathematical Definition


DAY 04 : In Class WorK
__________________________________________________________________
	In Class Assignment
	______________________________________________________________

	// Write Following Sum Function In C
		// It should RETURN Valid SUM [ As Per Mathematics Rules ]
		// or Otherwise Print Can't Calculate Sum For Given x and y

	int sum( int x, int y ) {

	}

	// Copy Your Code In Discussion Sheet

	In Class Assignment
	______________________________________________________________
	Is Java int Type Leads to Underflow/Overlow 
		Yes/No
		Design Mitigration Strategy


DAY 05
__________________________________________________________________
	A1. Coding And Practice Examples
	______________________________________________________________
		Till Today Code Examples Practice and Study

	A2. Reading Assignments and Code Practice Assignments
	______________________________________________________________
		A2.1. Java Reference Material [ MUST ]
			Read Following Chapters And Practice Code
				First 10 Chapters Including Exception Handling

			Reference Material
				Java Complete Reference, 8th/11th Edition
		
		A2.2. C Language : Reading and Understand [ MUST ]
			Read Following Chapters
				Chapters : Data Types, Functions, Array and Pointers
				
			Reference Material
				Programming In C, Kernigham And Denish Ritchie

		A2.3. Operating System Design and Internals [ MUST ]
			Read and Understand Following Chapters
				First 4 Chapters
			
			Reference Material
				Operating Systems: Internals and Design Principles, William Stallings

		A2.4. Data Structure Design : Read And Understand [ MUST ]
			Read Following Chapters	
				1. Programming Principles
				2. Introduction To Stack 
				3. Queues
				4. Linked Stack and Queues
			
			Reference Material
				Data Structure and Program Design in C++, 2nd Edition
					By Robert L. Kruse Alexander J. Ryba

				Data Structure and Program Design in C
					By Kruse and Tondo

		A2.5. Floating Points Reading and Understanding [ AWESOME ]
			https://en.wikipedia.org/wiki/Single-precision_floating-point_format
			https://en.wikipedia.org/wiki/Double-precision_floating-point_format

			Further Interested Learner: [ AWESOME ]
				IEEE 754 Floating Point Standards

			What All Operators Will Lead To Overlow/Underlow?
				Design Mitigation Strategies For Each One!
			
			Is Floating Point Can Overlow/Underlow?
				If Yes Then How and Design Mitigation Strategies

			What Every Computer Scientist Should Know About Floating-Point Arithmetic
			What Every Computer Scientist Should Know About Floating-Point Arithmetic
					DAVID GOLDBERG, Xerox Palo Alto Research C
				https://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html


	A3. Coding Assignments
	______________________________________________________________
		Write Program In C To Calculate Factorial of Any Large N.
			Without Using Any Libraries.

	A4. Exploration Assignments
	______________________________________________________________
		Modulus Operator
			What is The Definition of Modulus Operator in Mathematics?
			Compare Working of Modulus Operator in C, C++ and Java
				Reason Deviation From Mathematical Definition
				Why?

		Framework Design Exploration and Reasoning	
			1. Explore and Understand Internal Working of StringBuilder
			2. Reason Design Choices Made In StringBuilder Class
			3. Understand StringBuffer Design Choices
			

DAY 06
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________

	A1. Coding And Practice Examples [ MUST ]
	______________________________________________________________
		Till Today Code Examples Practice and Study

	A2. Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf

	A3. Coding Assignments [ MUST ]
	______________________________________________________________
		Q1. Write Program In C To Simulate Following 2D Arrays
			Q1.1. Using Array Of Pointers
			Q1.2. Using Only Pointers

	    public void workingWith2DArray() {
	        int[][] square = {
	                { 16, 3, 2, 13 },
	                { 3, 10, 11, 8 },
	                { 9, 6, 7, 12 },
	                { 4, 15, 14, 1}
	        };

	        int[] temp = square[0];
	        square[0] = square[1];
	        square[1] = temp;
	        System.out.println(Arrays.deepToString(square));

	// [[3, 10, 11, 8], [16, 3, 2, 13], [9, 6, 7, 12], [4, 15, 14, 1]]
	    }


	A4. Reading Assignments and Understanding Assignments [ AWESOMENESS ]
	______________________________________________________________
		Stmashing Stack For Fun and Profit!


DAY 07
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________

	A1. Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf [ Complete ]
		CoreJavaSE9.2.pdf [ Complete ]
		CoreJavaSE9.3.pdf [ Till Page 113 ]
			Section 3.1
			Section 3.2
			Section 3.3
		CoreJavaSE9.4.pdf [ Till Page 145 ]
			Section 4.1

	A2. Coding And Practice Examples [ MUST ]
	______________________________________________________________
		Till Today Code Examples Practice and Study

	A3. Coding Assignments [ MUST ]
	______________________________________________________________
		Q3.1 Simulate Networks of Networks Using Following Classes 
			class Network {
			    public class Member { 

			    }
			}
		Q3.2 Simulate Core Functionality of Facebook Network 
			Design Question [ Open Question ]

DAY 08
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________

	A1. Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf [ Complete ]
		CoreJavaSE9.2.pdf [ Complete ]
		CoreJavaSE9.3.pdf [ Complete ]
		CoreJavaSE9.4.pdf [ Complete ]

	A2. Coding And Practice Examples [ MUST ]
	______________________________________________________________
		Till Today Code Examples Practice and Study

	A3. Coding Assignments [ MUST ]
	______________________________________________________________
		Q3.0 Simulate Polymporphic Calculator
				By Passing Behaviour To Behaviour
		Q3.1 Simulate Networks of Networks Using Following Classes 
			class Network {
			    public class Member { 

			    }
			}
		Q3.2 Simulate Core Functionality of Facebook Network 
			Design Question [ Open Question ]

DAY 09
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________

	A1. Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf [ ReviseIt! ]
		CoreJavaSE9.2.pdf [ ReviseIt! ]
		CoreJavaSE9.3.pdf [ ReadThroughly! ]
		CoreJavaSE9.4.pdf [ ReadThroughly! ]

	A2. Coding And Practice Examples [ MUST ]
	______________________________________________________________
		Till Today Code Examples Practice and Study


	A3. Coding Assignments [ MUST ]
	______________________________________________________________
		Q3.0 Simulate Polymporphic Calculator
				By Passing Behaviour To Behaviour

		Q3.1 Simulate Networks of Networks Using Following Classes 
			class Network {
			    public class Member { 

			    }
			}
		Q3.2 Simulate Core Functionality of Facebook Network 
			Design Question [ Open Question ]

DAY 10
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________

	A1.1 Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf [ ReviseIt! ]
		CoreJavaSE9.2.pdf [ ReviseIt! ]
		CoreJavaSE9.3.pdf [ ReviseIt! ]
		CoreJavaSE9.4.pdf [ ReviseIt! ]

		CoreJavaSE9.5.pdf [ CompleteIt! ]
		CoreJavaSE9.7.pdf [ CompleteIt! ]

	A1.2 Reading and CODE DESIGN ASSIGNMENT  [ MUST MUST ]
	______________________________________________________________	
		ObjectOrientedDesign.pdf 
			Introduction To Object-Oriented Design
			Object-Oriented Design and Analysis
			Managing Dependencies
			Acquiring Behavior Through Inheritance
			Creating Flexible Interfaces

		[CODE SUBMISSION IN JAVA] 
		______________________________________________________________
			Everyone Will Submit Code In GitHub
				Every Commit By Commit
				Commit Comments Must Be Elaborate
					What Are You Designing?
					Design Decisions
					Implementation Decisions
					Any Assumptions etc.
					ToDo List

	A2. Coding And Practice Examples [ MUST ]
	______________________________________________________________
		Till Today Code Examples Practice and Study


	A3. Coding Assignments [ MUST ]
	______________________________________________________________
		Q3.0 Simulate Polymporphic Calculator And Use Following Operation Enum
			By Passing Behaviour To Behaviour

			enum Operation {
			    ADD("+") {
			        public int eval(int arg1, int arg2) { return arg1 + arg2; }
			    },
			    SUBTRACT("-") {
			        public int eval(int arg1, int arg2) { return arg1 - arg2; }
			    },
			    MULTIPLY("*") {
			        public int eval(int arg1, int arg2) { return arg1 * arg2; }
			    },
			    DIVIDE("/") {
			        public int eval(int arg1, int arg2) { return arg1 / arg2; }
			    };

			    private String symbol;
			    Operation(String symbol) { this.symbol = symbol; }
			    public String getSymbol() { return symbol; }    
			    public abstract int eval(int arg1, int arg2);
			}

		Q3.1 Predict What Java Code Will Be Generated 
			For Above Enum Operation By Java Compiler


	A4. Additional Reading Material
	______________________________________________________________
		Object Class	
		https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
		https://www.baeldung.com/java-equals-hashcode-contracts

		Lambda Topic
		http://tutorials.jenkov.com/java/lambda-expressions.html
		https://www.baeldung.com/java-8-lambda-expressions-tips
		https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html


	A5. Highly Advanced Assignments [ AWESOMENESS ]
	______________________________________________________________
	Q5.1 How Enums in Java Created Internally and Stored
	Q5.2 Verify Is Following Prediction Is Right/Wrong?
		
		enum Size {
		    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
		    private String abbreviation;

		    Size(String abbreviation) {
		        this.abbreviation = abbreviation;
		    }

		    public String getAbbreviation() { return abbreviation; }
		}

		// Compiler Will Generate Code Similar To Following For Above Lines
		class Size {
			static final Size SMALL = new Size("S");
			static final Size MEDIUM = new Size("M");
			static final Size LARGE = new Size("L");
			static final Size EXTRA_LARGE = new Size("XL");

		    private String abbreviation;

		    private Size(String abbreviation) {
		        this.abbreviation = abbreviation;
		    }

		    public String getAbbreviation() { return abbreviation; }
		}
		Size.createEnumConstants();


DAY 11
__________________________________________________________________
	A0. Complete Pending Assignments [ MUST ]
	______________________________________________________________


	A1.1 Reading Assignments and Code Practice Assignments [ MUST ]
	______________________________________________________________
		CoreJavaSE9.1.pdf [ ReviseIt! ]
		CoreJavaSE9.2.pdf [ ReviseIt! ]
		CoreJavaSE9.3.pdf [ ReviseIt! ]
		CoreJavaSE9.4.pdf [ ReviseIt! ]
		CoreJavaSE9.5.pdf [ ReviseIt! ]
		CoreJavaSE9.7.pdf [ ReviseIt! ]

		CoreJavaSE9.6.pdf [ CompleteIt! ]
		CoreJavaSE9.9.pdf [ CompleteIt! ]

	A1.2 Reading and DEFINITION DESIGN ASSIGNMENT  [ MUST MUST ]
	______________________________________________________________	
		ObjectOrientedDesign.pdf 
			Introduction To Object-Oriented Design
			Object-Oriented Design and Analysis
			Managing Dependencies
			Acquiring Behavior Through Inheritance
			Creating Flexible Interfaces

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		RAISE YOUR HAND: IF YOU COMPLETED ABOVE ASSIGNMENSTS
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



