class BankAccount:
    def __init__(self, account_no, pin_no):
        self.account_no = account_no
        self.pin_no = pin_no
        self.balance = 0

    def __str__(self):
        return f"{self.account_no} balance: {self.balance}"

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
            return True
        else:
            return False
    
    def get_balance(self):
        return self.balance
 
    def change_pin(self, old_pin, new_pin):
        if old_pin == self.pin_no:
            self.pin_no = new_pin
            return True
        return False

class SavingsAccount(BankAccount):
    interest_rate = 0.1

    def __init__(self, account_no, pin_no):
        super().__init__(account_no, pin_no)


    def add_interest(self):
        self.balance += self.balance * self.interest_rate


class FeeSavingsAccount(SavingsAccount):
    def __init__(self, account_no, pin_no, withdrawal_fee):
        super().__init__(account_no, pin_no)
        self.withdrawal_fee = withdrawal_fee

    def withdraw(self, amount):
        if self.balance >= amount + self.withdrawal_fee:
            self.balance -= amount
            self.balance -= self.withdrawal_fee
            return True
        else:
            return False




# Test
bank_acc = BankAccount(12345, 1234)
bank_acc.deposit(10000)
bank_acc.withdraw(5000)
print(bank_acc)

savings_bank_acc = SavingsAccount(123456, 1234)
savings_bank_acc.deposit(10000)
savings_bank_acc.withdraw(5000)
savings_bank_acc.add_interest()
print(savings_bank_acc)

fee_savings_bank_acc = FeeSavingsAccount(1234567, 1234, 100)
fee_savings_bank_acc.deposit(10000)
fee_savings_bank_acc.withdraw(5000)
fee_savings_bank_acc.add_interest()
print(fee_savings_bank_acc)
