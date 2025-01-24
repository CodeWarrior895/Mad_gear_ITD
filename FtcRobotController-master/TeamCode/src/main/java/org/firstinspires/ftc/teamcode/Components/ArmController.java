package org.firstinspires.ftc.teamcode.Components;

 import com.qualcomm.robotcore.hardware.CRServo;
 import com.qualcomm.robotcore.hardware.DcMotor;
 import com.qualcomm.robotcore.hardware.DcMotorSimple;
 import com.qualcomm.robotcore.hardware.Gamepad;
 import org.firstinspires.ftc.robotcore.external.Telemetry;

 import com.qualcomm.robotcore.hardware.HardwareDevice;
 import com.qualcomm.robotcore.hardware.HardwareMap;
 import com.qualcomm.robotcore.hardware.Servo;


public class ArmController {

     DcMotor liftLeft;                                                                                                                                                                                                                                                                                                                                                                                                                                                             
     DcMotor liftRight;
     Servo intake;
     Servo intakeRight;
     Servo intakeLeft;
     CRServo armLeft;
     CRServo armRight;
     CRServo rotator;


     Gamepad gamepad2;
     Telemetry telemetry;

     public ArmController(HardwareMap hardwareMap) {
         liftLeft = hardwareMap.get(DcMotor.class, "liftLeft");
         liftRight = hardwareMap.get(DcMotor.class, "liftRight");

         intake = hardwareMap.get(Servo.class, "intake");
         intakeLeft = hardwareMap.get(Servo.class, "intakeLeft");
         intakeRight = hardwareMap.get(Servo.class, "intakeRight");

         armLeft = hardwareMap.get(CRServo.class, "armLeft");
         armRight = hardwareMap.get(CRServo.class, "armRight");

         intakeLeft.setDirection(Servo.Direction.FORWARD);
         intakeRight.setDirection(Servo.Direction.REVERSE);

         liftLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         liftRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

         liftLeft.setDirection(DcMotor.Direction.FORWARD);
         liftRight.setDirection(DcMotor.Direction.REVERSE);

         liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     }


     public void init(Gamepad gamepad2, Telemetry telemetry) {
         this.telemetry = telemetry;
         this.gamepad2 = gamepad2;
     }


     public void openIntake() {
         intake.setPosition(1);
     }
     public void closeIntake() {
         intake.setPosition(0);
     }

    public void armDown() {
        armLeft.setPower(-0.5);
        armRight.setPower(-0.5);
    }
    public void armUp() {
        armRight.setPower(0.5);
        armLeft.setPower(0.5);
    }



     public void Control() {

         if(gamepad2.x) {
             openIntake();
         } else if (gamepad2.b) {
             closeIntake();
         }



         if(gamepad2.dpad_up) {
             armUp();
         } else if (gamepad2.dpad_down) {
             armDown();
         }



         
         if(gamepad2.right_trigger>0) {
             rotator.setPower(-0.2);
         } else if (gamepad2.left_trigger > 0) {
             rotator.setPower(0.2);
         }
         else {
             rotator.setPower(0);
         }



         if(gamepad2.left_stick_y > 0) {
          liftLeft.setPower(-0.65);
          liftRight.setPower(-0.65);
          }
          else if (gamepad2.left_stick_y < 0) {
          liftLeft.setPower(0.65);
          liftRight.setPower(0.65);
          }
          else {

              liftLeft.setPower(0);
              liftRight.setPower(0);
              liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
              liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
          }

     }
 }