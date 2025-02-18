# System design
## Description
- Tickiz allows users to easily browse, book, manage tickets for various events, such as concerts, sports games, conferences, and more. 
- This platform aims to provide seamless experience for event organizers, venders, and attendees by integrating various features for ticket sales, event management, and user interaction
## Key features
1. **Event discovery and booking**
- *Browse Events*: Users can search for events by category, location, date, or popularity.
- *Ticket Booking*: Allows users to select seats (if applicable), choose ticket types (VIP, Regular), and complete the purchase.
- *Multiple Payment Methods*: Supports various payment options like credit cards, PayPal, or even cryptocurrency.
- *QR Code Generation*: After purchase, users receive a unique QR code for event entry
2. **Event Management for Organizers**
- *Event Creation*: Event organizers can easily create and publish their events with necessary details (date, venue, ticket categories, pricing).
- *Ticketing Control*: Manage available tickets, set ticket limits, and track sales in real-time.
- *Analytics & Reports*: View detailed reports on ticket sales, revenue, and audience demographics
- *Event Promotion*: Integrates with social media and email marketing tools to promote events.
3. **User Profiles & Preferences**
- *Account Management*: Users can create accounts, manage their bookings, and track past events.
- *Event Recommendations*: Personalized event recommendations based on user preferences and past bookings.
- *Wishlists & Alerts*: Users can add events to their wishlist and set up notifications for ticket availability or price drops.
4. **Real-Time Updates & Notifications**
- *Ticket Availability*: Real-time updates on seat availability and ticket sales status.
- *Event Reminders*: Notifications before the event starts, with relevant event details.
- *Emergency Notifications*: Alert users in case of changes (e.g., event cancellations, schedule changes)
5. **Admin Dashboard**
- *Ticket Sales Management*: Admins can view and manage all ticket sales and user transactions.
- *Customer Support*: Built-in system to handle user queries, refunds, and ticket cancellations.
- *Reports & Insights*: Generate revenue reports, customer demographics, and sales trends to optimize event strategy.

## Technology stack
1. **Backend**
- Java 21 (Spring Boot, webflux)
- Database: MySQL
- Redis: caching popular events
- Kafka: event processing: Ticket order, ticket cancel, send notification
- JWT & Oauth2: Third parties login
- Websocket: Check remaining tickets in real-time
- Deploy: K8s
2. **Frontend**
- Angular
- NgRx: State management
- Bootstrap/TailwindCSS
3. **Payment system**
- VNPay, Momo, Stripe, Paypal API
4. **Notification and reminder**
- Email
- Discord
- Telegram
5. **Logging and monitoring** 
- ELK: user interactions tracking, logs
- Grafana + prometheous: system monitoring

## Main flow
1. User login, select event => select seat => order ticket
2. System check remaining ticket
3. If has ticket => lock ticket (redis)
4. User pay the bill: paypal, momo,...
5. Success => send notification by email/discord/... (kafka)
6. Payment fail: reopen ticket
7. Event is coming => Remind user