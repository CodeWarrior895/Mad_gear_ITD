package org.firstinspires.ftc.teamcode.Components;

 import com.qualcomm.robotcore.hardware.DcMotor;
 import com.qualcomm.robotcore.hardware.Gamepad;
 import org.firstinspires.ftc.robotcore.external.Telemetry;
 import com.qualcomm.robotcore.hardware.HardwareMap;


 public class ArmController {
     private double OARM=0 ;

     DcMotor motorLeft;
     DcMotor motorRight;

     DcMotor mainArmLeft;
     DcMotor mainArmRight;

     Gamepad gamepad2;
     Telemetry telemetry;

     public ArmController(HardwareMap hardwareMap) {
         motorLeft = hardwareMap.get(DcMotor.class, "liftLL");
         motorRight = hardwareMap.get(DcMotor.class, "liftRL");

         motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

         motorLeft.setDirection(DcMotor.Direction.REVERSE);
         motorRight.setDirection(DcMotor.Direction.FORWARD);

         motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     }


     public void init(Gamepad gamepad2, Telemetry telemetry) {
         this.telemetry = telemetry;
         this.gamepad2 = gamepad2;
     }

     public void Up() {
         motorLeft.setPower(0.2);
         motorRight.setPower(0.2);
     }

     public void Down() {

     }

     public void Control() {

                 OARM   = gamepad2.right_stick_y;
                 motorRight.setPower(0.7*OARM);
                 motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                 OARM   = -gamepad2.right_stick_y;
                 motorLeft.setPower(-0.7*OARM);
                 motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         // if(gamepad2.dpad_up) {
         // motorLeft.setPower(0.65);
         // motorRight.setPower(0.65);
         // }
         // else if (gamepad2.dpad_down) {
         // motorLeft.setPower(-0.65);
         // motorRight.setPower(-0.65);
         // }
         // else {

         // motorLeft.setPower(0);
         // motorRight.setPower(0);
         // motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         // motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         // }
     }
 }