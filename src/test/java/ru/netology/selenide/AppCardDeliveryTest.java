package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppCardDeliveryTest {

    @Test
    public void shouldBeLoadPage() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Калуга");
        $("[data-test-id='date'] input").setValue("20.03.2024");
        $("[data-test-id='name'] input").setValue("Иванов Иван");
        $("[data-test-id='phone'] input").setValue("+79997775533");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на 15.03.2024"));
    }
}

// java -jar ./artifacts/app-card-delivery.jar
// Поскольку файлы с расширением .jar находят в списках .gitignore,
// вам нужно принудительно заставить Git следить за ним: git add -f artifacts/app-card-delivery.jar