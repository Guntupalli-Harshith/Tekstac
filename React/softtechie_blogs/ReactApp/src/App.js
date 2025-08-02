// App.js
import React, { useState } from 'react';
import { connect } from 'react-redux';
import { addPost } from './Actions';
import './App.css';

function App({ posts, addPost }) {
  // Define local state variables for post title and content
  const [postTitle, setPostTitle] = useState('');
  const [postContent, setPostContent] = useState('');

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (postTitle && postContent) {
      // Dispatch the addPost action with title and content
      addPost(postTitle, postContent);
      // Reset form fields after submission
      setPostTitle('');
      setPostContent('');
    }
  };

  return (
    <div className="wrapper">
      <h3 style={{ textAlign: "center", backgroundColor: "gray", padding: "20px" }}>
        Soft Techie - Blogs
      </h3>
      <div style={{ marginLeft: "230px" }}>
        {/* Form for adding a new post */}
        <form onSubmit={handleSubmit}>
          <div style={{ marginBottom: "10px" }}>
            <label htmlFor="title">Title: </label>
            <input
              id="title"
              type="text"
              value={postTitle}
              onChange={(e) => setPostTitle(e.target.value)}
              style={{ padding: "8px", marginLeft: "10px", width: "300px" }}
            />
          </div>
          <div style={{ marginBottom: "10px" }}>
            <label htmlFor="content">Content: </label>
            <textarea
              id="content"
              value={postContent}
              onChange={(e) => setPostContent(e.target.value)}
              style={{ padding: "8px", marginLeft: "10px", width: "300px", height: "100px" }}
            />
          </div>
          <button type="submit">Add Post</button>
        </form>

        {/* Display list of posts */}
        <div style={{ marginTop: "30px" }}>
          <h2>Blog Posts</h2>
          {posts.length === 0 ? (
            <p>No posts yet. Add your first post!</p>
          ) : (
            posts.map((post) => (
              <div
                key={post.id}
                style={{
                  border: "1px solid #ccc",
                  margin: "10px 0",
                  padding: "15px",
                  backgroundColor: "#f9f9f9",
                  textAlign: "left",
                  width: "400px"
                }}
              >
                <h3 style={{ color: "#333", marginBottom: "10px" }}>{post.title}</h3>
                <p style={{ color: "#666" }}>{post.content}</p>
              </div>
            ))
          )}
        </div>
      </div>
    </div>
  );
}

// Map state to props for the App component
const mapStateToProps = (state) => ({
  posts: state.posts
});

// Map dispatch to props for the App component
const mapDispatchToProps = {
  addPost
};

// Wrap the App component with connect and assign it to ConnectedApp
const ConnectedApp = connect(mapStateToProps, mapDispatchToProps)(App);

// Export the ConnectedApp component as the default export
export default ConnectedApp;