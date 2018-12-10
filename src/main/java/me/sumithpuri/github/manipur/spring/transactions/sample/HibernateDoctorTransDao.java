package me.sumithpuri.github.manipur.spring.transactions.sample;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
public class HibernateDoctorTransDao extends HibernateDaoSupport {

	SessionFactory sessionFactory;
	
	
	public void addMultipleDoctors(List<Doctor> doctors) throws Exception {
		
		try {
			for(int i=0;i<doctors.size();i++) {
				getHibernateTemplate().save(doctors.get(i));
			}
		} catch (Exception e) {
			
			throw e;
		} finally {
			
			System.out.println("HibernateDoctoTransDao: Transaction to Add Multiple Doctors, Commit Status: "
					+ getSession().getTransaction().wasCommitted());

			System.out.println("HibernateDoctoTransDao: Completed All Database Operations (Transactions)!");
		}
	}
}
