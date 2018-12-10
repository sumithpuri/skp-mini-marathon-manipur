package me.sumithpuri.github.manipur.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.sumithpuri.github.manipur.spring.transactions.sample.Doctor;
import me.sumithpuri.github.manipur.spring.transactions.sample.HibernateDoctorTransDao;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Code Sample			Brainbench Spring 2.5 Certification [+ Spring In Action Samples]
 * Sample Topic			Core Spring (Transactions)
 * Certificate URL		https://goo.gl/X321kd
 * Package Prefix 		me.sumithpuri.github.manipur
 * Project Codename		manipur
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class Manipur {
	
	private static boolean isDatabaseSetup = false;

	public static void main(String[] args) {
	
		System.out.println("Copyright (c) 2018-19,	Sumith Kumar Puri");
		System.out.println();
		System.out.println("Project Codename      Manipur");
		System.out.println("Project Description   Core Spring (Transactions)");
		System.out.println("Certification         Brainbench Spring 2.5 Certification");
		System.out.println("Certificate URL	      https://goo.gl/X321kd");
		System.out.println("[Developer Notes]     [01] Use Java Version 9.0+ Compiler");
		System.out.println("[Developer Notes]     [02] Use MySQL 5.7+ Community Version");
		System.out.println();
		
		System.out.println();
		System.out.println("Example of Spring Transactions (Hibernate)");
		System.out.println("##########################################");
		
		if(isDatabaseSetup) {
		
			ApplicationContext context = new ClassPathXmlApplicationContext("transaction-sample.xml");
			HibernateDoctorTransDao doctorTransDao = (HibernateDoctorTransDao) context.getBean("doctorDaoTarget");
			List<Doctor> doctors = new ArrayList<Doctor>();
			
			try {
				
				Doctor doctor = new Doctor(7,"Nair", "Neurologist");
				doctors.add(doctor);
				doctor = new Doctor(8,"Iqbal", "Psychologist");
				doctors.add(doctor);
				doctor = new Doctor(9,"Sharma", "General");
				doctors.add(doctor);
				doctor = new Doctor(10,"Louis", "Opthalmologist");
				doctors.add(doctor);
				
				doctorTransDao.addMultipleDoctors(doctors);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} else {
			
			System.out.println("000. You may choose to Import the Project in Eclipse / Other IDE");
			System.out.println("000. Make Sure that Dependencies & Resources are in ClassPath");
			System.out.println("01a. Install MySQL Community Server Version 5.7.0+ [Developer Default]");
			System.out.println("01b. Make Sure that Schema is Created using [doctor.sql]");
			System.out.println("000. You may use MySQL Workbench or Eclipse to execute [doctor.sql]");
			System.out.println("02a. Make Sure you add the Password in the [transaction-sample.xml]");
			System.out.println("000. *Update the [isDatabaseSetup] attribute to [true] in [Manipur]*");
			System.out.println("02b. Next, Run [Manipur] from Eclipse / Command Line (With Classpath Set)");
			System.out.println("003. [Manipur] Spring Transactions Demo should show data from Database");
			System.out.println("004. *Exception will be thrown on the Console, if Records already Exist!*");
			System.out.println();
		}
	}
}
