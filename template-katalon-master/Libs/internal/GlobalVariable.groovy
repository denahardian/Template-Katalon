package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_AppsAndroid
     
    /**
     * <p></p>
     */
    public static Object G_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_ShortTimeout
     
    /**
     * <p></p>
     */
    public static Object G_LongTimeout
     
    /**
     * <p></p>
     */
    public static Object G_AppsIOS
     
    /**
     * <p></p>
     */
    public static Object G_ExcelPath
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            G_AppsAndroid = selectedVariables['G_AppsAndroid']
            G_Timeout = selectedVariables['G_Timeout']
            G_ShortTimeout = selectedVariables['G_ShortTimeout']
            G_LongTimeout = selectedVariables['G_LongTimeout']
            G_AppsIOS = selectedVariables['G_AppsIOS']
            G_ExcelPath = selectedVariables['G_ExcelPath']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
