package network;

import model.DailyAddedItem;
import model.Item;
import model.exception.MoneyException;
import ynab.client.api.AccountsApi;
import ynab.client.invoker.ApiClient;
import ynab.client.invoker.ApiException;
import ynab.client.invoker.Configuration;
import ynab.client.invoker.auth.ApiKeyAuth;
import ynab.client.model.AccountsResponse;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class YnabUser {
    private String token;
    private String accountID;

    public YnabUser() {
        token = "9d712bd3f769140d51a3c0c77dcc5646234ac2691de1c600c71d6eec05ff7e61";
        accountID = "b79ebeeb-6981-49e0-b020-2cef9ffb779d";
    }
    public double getCreditBlance() {
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
            money = result.getData().getAccounts().get(0).getBalance().doubleValue();
            money = (-1 * money) / 1000.00;

        } catch (ApiException e) {
            System.err.println("Exception when getting accounts");
            e.printStackTrace();
        }
        return money;
    }

    public Item newCreditItem() throws MoneyException {
        Item newItem;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        newItem = new DailyAddedItem(date, "rbc", this.getCreditBlance());
        return newItem;
    }
}
