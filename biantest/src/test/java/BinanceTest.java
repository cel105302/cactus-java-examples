import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;

public class BinanceTest {
    public static void main(String[] args) {
        String apiKey = "m4aKzn5BVBihM4fe0AQg2X2TL1juhvio4Z4iLFJGtqd8geChCX1KyxaQPGweZV2s";
        String secret = "keBRO77Xi1jwDwdRPkeyfh2LQukHM7ImKuGRdhO1wVYITKEcKZ2s9f9r4nde8d3D";
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secret);
        BinanceApiRestClient client = factory.newRestClient();

        // Get account balances
        Account account = client.getAccount(6000000L, System.currentTimeMillis());
        System.out.println(account.getBalances());
        System.out.println(account.getAssetBalance("ETH"));
    }
}
