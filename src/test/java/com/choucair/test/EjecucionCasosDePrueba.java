package com.choucair.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PruebaEmpleoDisponibleSeleccionarVacante.class, PruebaEmpleoKeywords.class,
		PruebaEmpleoKeywordsNoEncontrado.class, PruebaEmpleoLocation.class, PruebaEmpleoLocationNoEncontrado.class,
		PruebaLinkEmpleos.class, PruebaLinkPrepararseParaAplicar.class, PruebaRedireccionaVacanteAnterior.class,
		PruebaRedireccionVacanteSiguiente.class, PruebaVacanteApplyForJob.class })
public class EjecucionCasosDePrueba {

}
