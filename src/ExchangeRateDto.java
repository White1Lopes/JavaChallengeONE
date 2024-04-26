import java.util.Dictionary;
import java.util.HashMap;

public record ExchangeRateDto(String result, String documentation, String terms_of_use, int time_last_update_unix,
                              String time_last_update_utc
        , int time_next_update_unix, String time_next_update_utc, String base_code,
                              HashMap<String, String> conversion_rates) {

}
