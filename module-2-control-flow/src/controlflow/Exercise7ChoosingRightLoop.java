package controlflow;

public class Exercise7ChoosingRightLoop {
    /*
     * 📘 Exercise 7 — Choosing the Right Loop (Enterprise Banking Perspective)
     *
     * 1) When is a `for` loop more appropriate than a `while` loop in banking systems?
     *
     * A `for` loop is most appropriate when the iteration count is deterministic
     * or when iterating over a well-defined collection of elements.
     *
     * In enterprise banking systems, this commonly occurs when processing
     * structured datasets retrieved from a database or external service.
     *
     * Enterprise banking example:
     * - Iterating through a list of transactions to generate a monthly statement.
     * - Applying batch interest calculations to all accounts in a portfolio.
     * - Processing scheduled payments in a nightly batch job.
     *
     * The `for` loop clearly expresses controlled iteration with initialization,
     * condition, and increment in a single structure, improving readability and maintainability.
     *
     *
     * 2) When should a `while` loop be preferred?
     *
     * A `while` loop is appropriate when the number of iterations is not known
     * in advance and depends on dynamic runtime conditions.
     *
     * In banking systems, this is common in validation and monitoring workflows
     * where execution continues until a business condition is satisfied.
     *
     * Enterprise banking example:
     * - Retrying authentication while the user credentials are invalid and
     *   the maximum attempt threshold has not been reached.
     * - Continuously polling an external payment gateway until a transaction
     *   reaches a final status (SUCCESS or FAILED).
     *
     * The `while` loop emphasizes condition-driven execution and is well-suited
     * for operational control flows.
     *
     *
     * 3) When should a `do-while` loop be preferred?
     *
     * A `do-while` loop is appropriate when business logic must execute at least once
     * before evaluating the continuation condition.
     *
     * In enterprise banking systems, this is typically used in interactive workflows
     * or menu-driven interfaces.
     *
     * Enterprise banking example:
     * - Displaying an ATM or online banking menu that must appear at least once
     *   before checking if the user wishes to continue.
     * - Requesting mandatory input (e.g., PIN entry) at least once before
     *   validating retry conditions.
     *
     * The `do-while` structure guarantees at least one execution cycle,
     * making it suitable for mandatory interaction scenarios.
     */

}
