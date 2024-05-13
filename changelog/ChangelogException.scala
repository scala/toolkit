enum ChangelogException extends Exception:
  case AlreadyExists()
  case IllegalDiffs()
  case UserRejection()

  override def getMessage(): String =
    this match
      case AlreadyExists() => "Changelog file already exists. Please use --overwrite to overwrite it."
      case IllegalDiffs() => "Cannot generate changelog due to illegal diffs."
      case UserRejection() => "Rejected changes."
      