package com.sundram.hiltexample;

import dagger.Component;

@Component
public interface CalculationComponent {
    Calculation getCal();
}
