import React, { useState } from 'react';
import '../../CSS Files/PostSharePage.css'; // Ensure the path is correct

const PostSharePage = () => {
  const [caption, setCaption] = useState('');
  const [image, setImage] = useState(null);

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      setImage(URL.createObjectURL(file));
    }
  };

  const handleShare = () => {
    alert('✅ Post shared successfully!');
    setCaption('');
    setImage(null);
  };

  return (
    <div className="post-share-wrapper">
      <div className="post-share-card">
        <h2 className="post-title">📸 Create New Post</h2>

        <div className="post-profile">
          <img
            src="https://via.placeholder.com/40"
            alt="Profile"
            className="post-avatar"
          />
          <span className="post-username">@your_username</span>
        </div>

        <textarea
          className="post-caption-input"
          placeholder="Write something meaningful..."
          value={caption}
          onChange={(e) => setCaption(e.target.value)}
        />

        {image && (
          <div className="image-preview-container">
            <img src={image} alt="Preview" className="post-preview-image" />
          </div>
        )}

        <label className="image-upload-label">
          📁 Upload Image
          <input
            type="file"
            accept="image/*"
            className="image-upload-input"
            onChange={handleImageChange}
          />
        </label>

        <button className="post-share-btn" onClick={handleShare}>
          🚀 Share Post
        </button>
      </div>
    </div>
  );
};

export default PostSharePage;
