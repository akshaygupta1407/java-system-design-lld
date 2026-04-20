package module3.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * MODULE 3.3: Observer Pattern
 *
 * Observer lets a subject notify multiple listeners when something changes.
 */

interface Subscriber {
    void update(String headline);
}

class EmailSubscriber implements Subscriber {
    @Override
    public void update(String headline) {
        System.out.println("Email subscriber received: " + headline);
    }
}

class SmsSubscriber implements Subscriber {
    @Override
    public void update(String headline) {
        System.out.println("SMS subscriber received: " + headline);
    }
}

class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private String headline;

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void setHeadline(String headline) {
        this.headline = headline;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(headline);
        }
    }
}

public class ObserverLesson {
    public static void main(String[] args) {
        System.out.println("--- Observer Demo ---");

        NewsAgency agency = new NewsAgency();
        Subscriber email = new EmailSubscriber();
        Subscriber sms = new SmsSubscriber();

        agency.subscribe(email);
        agency.subscribe(sms);

        agency.setHeadline("Breaking News: LLD is fun!");
        agency.unsubscribe(sms);
        agency.setHeadline("Update: Only email subscribers receive this.");
    }
}
