package com.may;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.event.DebugAgendaEventListener;

import com.may.model.Product;

public class Main {

	public static void main(String[] args) throws DroolsParserException,
			IOException {
		Main droolsTest = new Main();
		droolsTest.executeDrools();
	}

	public void executeDrools() throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		workingMemory.addEventListener(new DebugAgendaEventListener());

		Product product = new Product();
		product.setType("gold");
		product.setEvent("sale");
		workingMemory.insert(product);
		workingMemory.fireAllRules();

		System.out.println("The discount for the jewellery product "
				+ product.getType() + " is " + product.getDiscount());
	}

}
