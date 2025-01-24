 package org.firstinspires.ftc.teamcode;
 import com.qualcomm.robotcore.hardware.Servo;

 import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

 import org.firstinspires.ftc.teamcode.Components.ArmController;
 import org.firstinspires.ftc.teamcode.Components.DriveTrain;


 @TeleOp(name = "Mad_gear_2.0")

 public class Main extends LinearOpMode {
     DriveTrain drive;
     ArmController arm;

     @Override
     public void runOpMode() {
         drive = new DriveTrain(hardwareMap);
         drive.init(gamepad1, telemetry);

         arm = new ArmController(hardwareMap);

         waitForStart();

         while (opModeIsActive()) {
             arm.init(gamepad2, telemetry);
             arm.Control();
             drive.Control();
         }
     }
 }
