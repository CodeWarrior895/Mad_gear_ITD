 package org.firstinspires.ftc.teamcode;
 import com.qualcomm.robotcore.hardware.Servo;

 import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

 import org.firstinspires.ftc.teamcode.Components.ArmController;
 import org.firstinspires.ftc.teamcode.Components.DriveTrain;


 @TeleOp(name = "Mad_gear")

 public class Main extends LinearOpMode {
     DriveTrain drive;
     private Servo arm1 ,arm2 ,claw, ratata;
     ArmController arm;

     @Override
     public void runOpMode() {
         arm2 = hardwareMap.get(Servo.class, "arm2");
         arm1 = hardwareMap.get(Servo.class, "arm1");
         claw = hardwareMap.get(Servo.class, "claw");
         ratata = hardwareMap.get(Servo.class, "ratata");
         drive = new DriveTrain(hardwareMap);
         drive.init(gamepad1, telemetry);

         arm = new ArmController(hardwareMap);
         arm.init(gamepad2, telemetry);

         waitForStart();

         while (opModeIsActive()) {
             if (gamepad2.dpad_down) {
                     arm1.setPosition(-1);
                     arm2.setPosition(1);
                 }
                 if (gamepad2.dpad_up) {
                     arm1.setPosition(1);
                     arm2.setPosition(-1);
                 }
                 if (gamepad2.left_bumper) {
                     claw.setPosition(0);
                 }
                 if (gamepad2.right_bumper) {
                     claw.setPosition(1);
                 }
                 if (gamepad2.right_trigger == 1) {
                     ratata.setPosition(1);
                 }

                 if (gamepad2.left_trigger == 1) {
                     ratata.setPosition(0.55);
                 }

             drive.Control();
             arm.Control();
         }
     }
 }
