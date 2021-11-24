package com.techjs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techjs.entity.Product;
import com.techjs.entity.Variant;

public class LazyLoadingDemo 
{

	public static void main(String[] args) 
	{
		Product product = new Product();
		product.setpId(1002);
		product.setpName("Dell");
		
		Variant variant = new Variant();
		variant.setvId(103);
		variant.setPrice(200);
		variant.setvName("Dell-PRO");
		variant.setProduct(product);
		
		product.getVariant().add(variant);
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Variant.class);
		
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tn = session.beginTransaction();
		
		//session.save(variant);
		//session.save(product);
		
		Product prod = session.get(Product.class,1002);
		System.out.println("Product Id :"+prod.getpId());
		System.out.println("Product Name :"+prod.getpName());
		
//		for (Object obj : prod.getVariant())
//		{
//			Variant v = (Variant)obj;
//			System.out.println("Variant Name :"+v.getvName());
//			System.out.println("Variant Price :"+v.getPrice());
//		}
		
		tn.commit();
		session.close();
		sf.close();
		
		

	}

}
