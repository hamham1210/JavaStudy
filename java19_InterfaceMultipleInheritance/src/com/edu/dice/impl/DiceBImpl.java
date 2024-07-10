package com.edu.dice.impl;

import java.util.Random;

import com.edu.dice.Dice;

public class DiceBImpl implements Dice{
	private int value;
	
	public DiceBImpl() {
		
	}
public DiceBImpl(int value) {
		this.value = value;
	}

@Override
public void selectedNumber() {
	value = new Random().nextInt(6) + 1;
	
}
@Override
public int getValue() {
	return value;
}
}
