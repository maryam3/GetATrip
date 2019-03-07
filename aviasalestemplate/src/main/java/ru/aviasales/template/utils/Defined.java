package ru.aviasales.template.utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import ru.aviasales.core.locale.CountryCodes;
import ru.aviasales.core.locale.LanguageCodes;
import ru.aviasales.core.locale.LocaleUtil;
import ru.aviasales.core.utils.CoreDefined;

public class Defined extends CoreDefined {

	public static final String SEARCH_SERVER_DATE_FORMAT = "yyyy-MM-dd";
	public static final String SEARCH_FORM_DATE_FORMAT = "dd MMMM, yyyy";
	public static final String SEARCH_FORM_WEEK_DAY_FORMAT = "EEEE";

	public static final String AM_PM_RESULTS_TIME_FORMAT = "hh:mma";
	public static final String RESULTS_TIME_FORMAT = "HH:mm";
	public static final String RESULTS_SHORT_DATE_FORMAT = "d MMM";
	public static final String UTC_TIMEZONE = "Etc/UTC";

	public static final String TICKET_FLIGHT_TIME_FORMAT = "HH:mm";
	public static final String AM_PM_TICKET_FLIGHT_TIME_FORMAT = "hh:mma";
	public static final String TICKET_SHORT_DATE_FORMAT = "d MMM, EE";

	public static final String FILTERS_TIME_FORMAT = "HH:mm";
	public static final String AM_PM_FILTERS_TIME_FORMAT = "hh:mma";

	private static final String DEFAULT_CURRENCY = "RUB";
	private static final String EN_DEFAULT_CURRENCY = "USD";
	private static final String EN_GB_DEFAULT_CURRENCY = "GBP";
	private static final String EN_AU_DEFAULT_CURRENCY = "AUD";
	private static final String EN_IE_DEFAULT_CURRENCY = "IEP";
	private static final String ES_DEFAULT_CURRENCY = "EUR";
	private static final String IT_DEFAULT_CURRENCY = "EUR";
	private static final String DE_DEFAULT_CURRENCY = "EUR";
	private static final String FR_DEFAULT_CURRENCY = "EUR";
	private static final String TH_DEFAULT_CURRENCY = "THB";


	private static Map<String, String> CURRENCY_MAP;

	static {
		Map<String, String> aMap = new LinkedHashMap<String, String>();
		if (LocaleUtil.getLocale().equals(LanguageCodes.RUSSIAN)) {

			aMap.put("RUB", "Российский рубль");
			aMap.put("USD", "Доллар США");
			aMap.put("EUR", "Евро");
			aMap.put("UAH", "Украинская гривна");
			aMap.put("KZT", "Казахстанский тенге");
			aMap.put("ILS", "Израильский шекель");
			aMap.put("CHF", "Швейцарский франк");
			aMap.put("GBP", "Фунт стерлингов");
			aMap.put("AUD", "Австралийский доллар");
			aMap.put("CAD", "Канадский доллар");
			aMap.put("CNY", "Китайский юань");
			aMap.put("JPY", "Японская йена");
			aMap.put("AZN", "Азербайджанский манат");
			aMap.put("AMD", "Армянский драм");
			aMap.put("BYN", "Белорусский рубль");
			aMap.put("KGS", "Киргизский сом");
			aMap.put("MDL", "Молдавский лей");
			aMap.put("TJS", "Таджикский сомони");
			aMap.put("UZS", "Узбекский сум");
			aMap.put("GEL", "Грузинский лари");
			aMap.put("TMT", "Туркменский манат");

		} else {

			aMap.put("USD", "US Dollar");
			aMap.put("EUR", "Euro");
			aMap.put("AUD", "Australian Dollar");
			aMap.put("RUB", "Russian Rouble");
			aMap.put("GBP", "British Pound");
			aMap.put("INR", "Indian Rupee");
			aMap.put("SGD", "Singapore Dollar");
			aMap.put("HKD", "Hong Kong Dollar");
			aMap.put("NZD", "New Zealand Dollar");
			aMap.put("CNY", "Chinese Yuan");
			aMap.put("CAD", "Canadian Dollar");
			aMap.put("THB", "Thailand Baht");

		}
		CURRENCY_MAP = Collections.unmodifiableMap(aMap);
	}

	private static final String AIRLINE_LOGO_TEMPLATE_URL = "https://{SearchUrl}/images/airline/{Width}/{Height}/{IATA}.png";

	public static String getAirlineLogoTemplateUrl() {
		return getUrl(AIRLINE_LOGO_TEMPLATE_URL);
	}

	public static String getDefaultCurrency() {
		String locale = LocaleUtil.getLocale();

		if (locale.equalsIgnoreCase(LanguageCodes.ENGLISH + "_" + CountryCodes.GREAT_BRITAIN)) {
			return EN_GB_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.ENGLISH + "_" + CountryCodes.GREAT_BRITAIN)) {
			return EN_AU_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.ENGLISH + "_" + CountryCodes.GREAT_BRITAIN)) {
			return EN_IE_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.SPANISH)) {
			return ES_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.GERMAN)) {
			return DE_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.ITALIAN)) {
			return IT_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.THAI)) {
			return TH_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.FRENCH)) {
			return FR_DEFAULT_CURRENCY;
		} else if (locale.equalsIgnoreCase(LanguageCodes.RUSSIAN + "_" + LanguageCodes.RUSSIAN)
				|| locale.equalsIgnoreCase(LanguageCodes.RUSSIAN)) {
			return DEFAULT_CURRENCY;
		} else
			return EN_DEFAULT_CURRENCY;
	}

	public static Map<String, String> getCurrenciesArray() {
		return CURRENCY_MAP;
	}
}
