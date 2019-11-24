package network;

import model.DailyAddedItem;
import model.Item;
import ynab.client.api.AccountsApi;
import ynab.client.invoker.ApiClient;
import ynab.client.invoker.ApiException;
import ynab.client.invoker.Configuration;
import ynab.client.invoker.auth.ApiKeyAuth;
import ynab.client.model.AccountsResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YnabUser {
    private String token;
    private String accountID;

    public YnabUser() {
        token = "9d712bd3f769140d51a3c0c77dcc5646234ac2691de1c600c71d6eec05ff7e61";
        accountID = "b79ebeeb-6981-49e0-b020-2cef9ffb779d";
    }

    public double getCreditBalance() {
        double money = 0.0;
        ApiClient user = Configuration.getDefaultApiClient();
        ApiKeyAuth bearer = (ApiKeyAuth) user.getAuthentication("bearer");
        bearer.setApiKey(token);
        bearer.setApiKeyPrefix("Bearer");

        //https://github.com/daviddietz/ynab-sdk/blob/master/docs/TransactionsApi.md#getTransactions
        AccountsApi account = new AccountsApi();
        UUID budgetId = UUID.fromString(accountID); //The ID of the Budget.
        try {
            AccountsResponse result = account.getAccounts(budgetId);
            money = this.getMoney(result);

        } catch (ApiException e) {
            System.err.println("Exception when getting accounts");
            e.printStackTrace();
        }
        return money;
    }

    private double getMoney(AccountsResponse a) {
        double money = 0.0;
        String result = a.toString();
        String pattern = "(balance: )(.+)((\\d)*)";
        Pattern p = Pattern.compile(pattern);
        String line = result.toString();
        Matcher m = p.matcher(line);
        if (m.find()) {
            String s = m.group(0).substring(8);
            money = Double.parseDouble(s);
            money = ((-1) * money) / 1000.0;
        }
        return money;
    }

    public Item newCreditItem() {
        Item newItem;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        newItem = new DailyAddedItem(date, "RBC_Card", this.getCreditBalance());
        newItem.toPayMethod("CREDIT");
        return newItem;
    }
}
