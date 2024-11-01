**Situation**:  
At Joveo, a leading programmatic job ad tech company, I was part of the core tracking-ingestion team responsible for tracking job application events, which played a central role in revenue as charges to clients were only generated upon successful job application conversions. During a restructuring of responsibilities between teams, a miscommunication led to a critical production issue: our neighboring team, handling client creation logic, assumed our team would manage tracking ID creation. As a result, client creation events failed in production, and responsibility confusion delayed the resolution. Recognizing the urgency, I stepped up to lead the fix.

**Task**:  
My objective was to resolve the production bug and implement a robust, scalable solution to prevent future occurrences. With the client creation process stalled, all related messages were accumulating in the Dead Letter Queue (DLQ), highlighting that downstream services were overwhelmed and unable to process the events.

**Action**:
1. **Immediate Investigation & Architecture Review**: I first gathered all dependencies and data on the client creation flow, which involved an event-driven AWS SQS architecture with DLQ integration. Seeing the backlog of unprocessed events, I analyzed how to reprocess these failed events systematically.

2. **Architecture Optimization**:
    - **Refactoring Queue Dependency**: Originally, tracking IDs were generated and passed to downstream services via a secondary SQS queue, adding network latency and costs. I redesigned this solution to write tracking IDs directly to MongoDB within the main process, eliminating the need for the secondary queue. This reduced network overhead and allowed real-time in-memory processing, lowering latency.
    - **Exponential Backoff and Retry Logic**: I implemented an exponential backoff and retry strategy to avoid overwhelming downstream services with reattempts. This mechanism throttled message reprocessing attempts, preventing overload and smoothing out recovery.

3. **Local Testing & Validation**:
    - I used AWS Local and cloud mimic tools to replicate SQS and MongoDB on my local machine. By testing the complete workflow with sample messages, I confirmed that tracking IDs were generated, written to MongoDB, and handled accurately. I also implemented comprehensive logging to trace each event through the pipeline.

4. **Monitoring & Alerting Configurations**:
    - Configured AWS CloudWatch to track metrics like DLQ spikes and message processing latency, setting up alerts to notify the team of any unusual DLQ growth. This proactive monitoring ensured future message buildups would be addressed immediately, preventing delays in client creation.

5. **Preventive Measures and Team Collaboration**:
    - To prevent similar issues, I introduced a checklist-based validation process across the team to ensure dependencies, ownership, and documentation were clarified before production deployments. I also organized a team session to share key learnings, fostering clearer communication and stronger cross-team accountability.

**Result**:  
The solution restored the client creation flow, and I validated success through real-time monitoring of DLQ backlog and latency metrics on CloudWatch and Grafana. Within hours, the DLQ backlog cleared as messages were reprocessed, while the revised architecture improved processing speed by approximately 15%. By eliminating the secondary SQS queue, this redesign led to an estimated monthly cost savings of around $1,500 from reduced AWS SQS charges and operational costs. Additionally, the improved processing flow and proactive monitoring reduced the likelihood of similar issues, while cross-team engagement strengthened responsibility clarity across teams.

---

**Rating**: 9.5/10

**Further Suggestions**:
- **Highlight Long-Term Benefits**: Mention the potential reduction in engineering hours saved from fewer bug fixes due to better preventive measures.
- **Provide Greater Detail on Team Collaboration**: Share if any process documentation updates were made for onboarding new team members.
