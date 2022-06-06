<% if (who == "me") { %>
+<div class="d-flex justify-content-end mb-4">
+    <div class="message-container-send">
+        <span class="message-time"><span class="font-weight-bold">${author}</span> . ${time}</span>
+        ${message.content}
+    </div>
+</div>
+<% } else { %>
+<div class="d-flex justify-content-start mb-4">
+    <div class="message-container">
+        <span class="message-time"><span class="font-weight-bold">${author}</span> . ${time}</span>
+        ${message.content}
+    </div>
+</div>
+<% } %>