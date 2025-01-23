 package org.firstinspires.ftc.teamcode.Components;

 import com.qualcomm.robotcore.hardware.DcMotor;
 import com.qualcomm.robotcore.hardware.Gamepad;
 import org.firstinspires.ftc.robotcore.external.Telemetry;
 import com.qualcomm.robotcore.hardware.HardwareMap;

 public class DriveTrain {

     DcMotor motorLF;
     DcMotor motorLB;
     DcMotor motorRF;
     DcMotor motorRB;

     Gamepad gamepad1;
     Telemetry telemetry;
     public DriveTrain(HardwareMap hardwareMap) {
         motorLF = hardwareMap.get(DcMotor.class, "motorLF");
         motorLB = hardwareMap.get(DcMotor.class, "motorLB");
         motorRF = hardwareMap.get(DcMotor.class, "motorRF");
         motorRB = hardwareMap.get(DcMotor.class, "motorRB");

         motorLF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         motorLB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         motorRF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         motorRB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

         motorLF.setDirection(DcMotor.Direction.REVERSE);
         motorLB.setDirection(DcMotor.Direction.REVERSE);
         motorRF.setDirection(DcMotor.Direction.FORWARD);
         motorRB.setDirection(DcMotor.Direction.FORWARD);

         motorLF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         motorLB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         motorRF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         motorRB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     }

     public void init(Gamepad gamepad1, Telemetry telemetry) {
         this.telemetry = telemetry;
         this.gamepad1 = gamepad1;
     }

     public void power(double a, double b, double c, double d) {
         motorLF.setPower(a);
         motorLB.setPower(b);
         motorRF.setPower(c);
         motorRB.setPower(d);
     }

     public void Control() {
         double leftY = gamepad1.left_stick_y;
         double rightY = gamepad1.right_stick_y;

         power(leftY, leftY, rightY, rightY);


         telemetry.addData("Motor Power", "LF: %.2f, LB: %.2f, RF: %.2f, RB: %.2f",
                 motorLF.getPower(), motorLB.getPower(), motorRF.getPower(), motorRB.getPower());
         telemetry.update();
     }
 }
