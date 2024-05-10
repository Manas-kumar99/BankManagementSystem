package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    Thread t;

    Project(){
        setSize(1367,768);
        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366,678, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        //---------------New Information------------------------------------------------
        JMenuBar mb =new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        mb.add(newInformation);
        newInformation.setForeground(Color.BLUE);


        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem StudentInfo = new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.WHITE);
        StudentInfo.addActionListener(this);
        newInformation.add(StudentInfo);

        JMenuItem CollageInfo = new JMenuItem("New Collage Information");
        CollageInfo.setBackground(Color.WHITE);
        newInformation.add(CollageInfo);

        //----------------Detail------------------------------------------------

        JMenu details = new JMenu("New Details");
        mb.add(details);
        details.setForeground(Color.RED);


        JMenuItem facultydetails = new JMenuItem("View faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem Studentdetails = new JMenuItem("View Student Details");
        Studentdetails.setBackground(Color.WHITE);
        Studentdetails.addActionListener(this);
        details.add(Studentdetails);

        //------------------------Leave-----------------------------
        JMenu leave = new JMenu("Apply Leave");
        mb.add(leave);
        leave.setForeground(Color.BLUE);


        JMenuItem facultyleave = new JMenuItem("faculty leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem Studentleave = new JMenuItem("Student leave");
        Studentleave.setBackground(Color.WHITE);
        Studentleave.addActionListener(this);
        leave.add(Studentleave);


        //------------------------Leave-Details--------------------------
        JMenu leaveDetails = new JMenu("Leave Detail");
        mb.add(leaveDetails);
        leaveDetails.setForeground(Color.RED);


        JMenuItem facultyleaveDetails = new JMenuItem(" faculty leave Detail");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem StudentleaveDetail = new JMenuItem(" Student leave Detail");
        StudentleaveDetail.setBackground(Color.WHITE);
        StudentleaveDetail.addActionListener(this);
        leaveDetails.add(StudentleaveDetail);


        //------------------------Exam-Details--------------------------
        JMenu exam = new JMenu("Examinaion ");
        mb.add(exam);
        exam.setForeground(Color.BLUE);


        JMenuItem examinationdetails = new JMenuItem(" Examination Result");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem(" Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //------------------------Update-Details--------------------------
        JMenu updateInfo = new JMenu("Update Detail ");
        mb.add(updateInfo);
        updateInfo.setForeground(Color.RED);


        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Detail");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem(" Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //------------------------Fees-Details--------------------------
        JMenu Fee = new JMenu("Fees Detail ");
        mb.add(Fee);
        Fee.setForeground(Color.BLUE);


        JMenuItem Feestructure = new JMenuItem("Fees Structure");
        Feestructure.setBackground(Color.WHITE);
        Feestructure.addActionListener(this);
        Fee.add(Feestructure);

        JMenuItem Feeform = new JMenuItem("Student Fees Form");
        Feeform.setBackground(Color.WHITE);
        Feeform.addActionListener(this);
        Fee.add(Feeform);


        //------------------------About--------------------------
        JMenu about = new JMenu("About  ");
        mb.add(about);
        about.setForeground(Color.RED);


        JMenuItem aboutUniversity = new JMenuItem("About University");
        aboutUniversity.setBackground(Color.WHITE);
        aboutUniversity.addActionListener(this);
        about.add(aboutUniversity);

        JMenuItem collage = new JMenuItem("About collage");
        collage.setBackground(Color.WHITE);
        collage.addActionListener(this);
        about.add(collage);

        //------------------------Utility--------------------------
        JMenu utility = new JMenu("Utility ");
        mb.add(utility);
        utility.setForeground(Color.BLUE);


        JMenuItem notepad = new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem Calc = new JMenuItem("Calculator");
        Calc.setBackground(Color.WHITE);
        Calc.addActionListener(this);
        utility.add(Calc);

        //------------------------About Developer--------------------------
        JMenu developer = new JMenu("Developed BY ");
        developer.setForeground(Color.RED);
        mb.add(developer);


        JMenuItem Developer = new JMenuItem("Developer");
        Developer.setBackground(Color.WHITE);
        Developer.addActionListener(this);
        developer.add(Developer);




        //------------------------exit--------------------------
        JMenu exit = new JMenu("Exit ");
        exit.setForeground(Color.BLUE);

        mb.add(exit);


        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);



        setJMenuBar(mb);
        setVisible(true);
    }



    public static void main(String[] args) {
    new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
           try{
               Runtime.getRuntime().exec("calc.exe");
           }catch (Exception ae){

           }

        }else if(msg.equals("NotePad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ae){

            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        }else if (msg.equals("View faculty Details")) {
            new TeacherDetail();
        }else if (msg.equals("View Student Details")) {
            new StudentDetail();
        }else if (msg.equals("faculty leave")) {
            new TeacherLeave();
        }else if (msg.equals("Student leave")) {
            new StuudentLeave();
        }else if (msg.equals(" faculty leave Detail")) {
            new TeacherleaveDetail();
        }else if (msg.equals(" Student leave Detail")) {
            new StudentleaveDetail();
        }else if (msg.equals("Update Faculty Detail")) {
            new UpdateTeacher();
        }else if (msg.equals(" Update Student Details")) {
            new UpdateStudent();
        }
        else if (msg.equals(" Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals(" Examination Result")) {
            new ExaminationDetails();
        }else if (msg.equals("Fees Structure")) {
            new FeeStructure();
        } else if (msg.equals("About University")) {
            new About();
        } else if (msg.equals("About collage")) {
            new Pcollage();
        }else if (msg.equals("Developer")) {
            new DevelopedBy();
        }else if (msg.equals("Student Fees Form")) {
            new StudentFeeForm();
        }


    }
}
